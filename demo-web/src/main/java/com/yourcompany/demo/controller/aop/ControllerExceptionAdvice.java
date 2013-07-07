/**
 * 
 */
package com.yourcompany.demo.controller.aop;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Catch bind exceptions and return a json containing what went wrong.
 * 
 * @author wwadge
 *
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody List<FieldError> handleBindException(BindException ex) {
		return ex.getBindingResult().getFieldErrors();
	}
}
