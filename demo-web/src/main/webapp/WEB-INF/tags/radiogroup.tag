<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true" description="Name of corresponding property in bean object"%>
<%@ attribute name="label" required="true" rtexprvalue="true" description="Label appears in red color if input is considered as invalid after submission"%>
<%@ attribute name="items" required="true" rtexprvalue="true" description="Buttons to show, comma separated"%>
<%@ attribute name="defaultActive" required="true" rtexprvalue="true" description="index (0 based) to set as default"%>


<div class="control-group">
	<label class="control-label">${label}</label>
	<div class="controls">
		<div class="btn-group" data-toggle-name="${name}"
			data-toggle="buttons-radio">
			<c:forTokens items="${items}" delims="," var="ele" varStatus="status">
			<c:set var="countStatus">${status.count-1}</c:set>
				<button type="button" value="${status.count-1}" class="btn ${defaultActive == countStatus ? 'active' : ''}" data-toggle="button">${ele}</button>
			</c:forTokens>
		</div>
		<input type="hidden" name="${name}" id="${name }" value="0" />
	</div>
</div>
