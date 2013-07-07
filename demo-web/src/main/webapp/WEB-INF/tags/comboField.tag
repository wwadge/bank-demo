<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true" description="Name of corresponding property in bean object"%>
<%@ attribute name="label" required="true" rtexprvalue="true" description="Label appears in red color if input is considered as invalid after submission"%>
<%@ attribute name="ngmodel" required="false" rtexprvalue="true"
	description="Angular model object"%>
<%@ attribute name="ngoptions" required="false" rtexprvalue="true"
	description="Angular model object"%>


<spring:bind path="${name}">
	<c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
	<div class="${cssGroup}" id="${name}">
		<label class="control-label">${label}</label> 
		<div class="controls">
			<form:select path="${name}" ng-model="${ngmodel}" ng-options="${ngoptions}" name="${name}" class="combobox" />
			<span class="help-inline">${status.errorMessage}</span>
		</div>
	</div>
</spring:bind>


