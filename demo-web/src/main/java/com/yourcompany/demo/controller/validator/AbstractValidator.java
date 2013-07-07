/**
 * 
 */
package com.yourcompany.demo.controller.validator;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.Errors;

/** This make spring use both the @Valid annotations as well as call any custom code registered
 * See: http://stackoverflow.com/questions/7080684/spring-validator-having-both-annotation-and-validator-implementation
 * 
 * @author wwadge
 *
 */
public abstract class AbstractValidator implements org.springframework.validation.Validator, ApplicationContextAware, ConstraintValidatorFactory {

	@Autowired
	private Validator validator;

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
		Map<String, T> beansByNames = applicationContext.getBeansOfType(key);
		if (beansByNames.isEmpty()) {
			try {
				return key.newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException("Could not instantiate constraint validator class '" + key.getName() + "'", e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Could not instantiate constraint validator class '" + key.getName() + "'", e);
			}
		}
		if (beansByNames.size() > 1) {
			throw new RuntimeException("Only one bean of type '" + key.getName() + "' is allowed in the application context");
		}
		return beansByNames.values().iterator().next();
	}

	public boolean supports(Class<?> c) {
		return true;
	}

	public void validate(Object objectForm, Errors errors) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(objectForm);
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		addExtraValidation(objectForm, errors);
	}

	protected abstract void addExtraValidation(Object objectForm, Errors errors);
}