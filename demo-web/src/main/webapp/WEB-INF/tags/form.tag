<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="modelAttribute" required="true" rtexprvalue="true" %>
<%@ attribute name="id" required="true" rtexprvalue="true" %>
<%@ attribute name="legend" required="false" rtexprvalue="true" %>
<%@ attribute name="formUrl" required="true" rtexprvalue="true" %>
<spring:url value="${formUrl}" var="processedFormUrl" />
<form:form modelAttribute="${modelAttribute}" id="${id}" action="${processedFormUrl}" class="form-horizontal">
	<legend>${legend}</legend>
		<fieldset>
	       <jsp:doBody />
	    </fieldset>
</form:form>
 