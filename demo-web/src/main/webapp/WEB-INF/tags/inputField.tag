<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true"
	description="Name of corresponding property in bean object"%>
<%@ attribute name="label" required="true" rtexprvalue="true"
	description="Label appears in red color if input is considered as invalid after submission"%>
<%@ attribute name="ngmodel" required="false" rtexprvalue="true"
	description="Angular model object"%>
<%@ attribute name="placeholder" required="false" rtexprvalue="true"
	description="Label to appear inside input text"%>
<%@ attribute name="icon" required="false" rtexprvalue="true"
	description="Icon to appear inside input text"%>
 
<spring:bind path="${name}">
	<c:set var="cssGroup"
		value="control-group ${status.error ? 'error' : '' }" />
	<div class="${cssGroup}" id="${name}">
		<label class="control-label">${label}</label>
		<div class="controls">
			<div class="input-prepend">
				<span class="add-on"><i class="${icon}"></i></span>
				<form:input path="${name}" ng-model="${ngmodel}" name="${name}" class="input-xlarge"
					placeholder="${placeholder}"></form:input>
				<span class="help-inline">${status.errorMessage}</span>
			</div>
		</div>
	</div>
</spring:bind>

