<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:c="http://java.sun.com/jsp/jstl/core"  
xmlns:spring="http://www.springframework.org/tags" 
xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:form="http://www.springframework.org/tags/form"
>

<%@ taglib prefix="htmlf" tagdir="/WEB-INF/tags" %>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/form.js" ></script>

	<head>
	<style>
	.error{
        color: red;
}

.success{
        color: green;
}

form fieldset { padding: 20px; }
div.control-group { margin-bottom: 20px; }
div.control-group label.control-label { width: 140px; }
div.control-group div.controls { width: 400px; }
div.controls span { color: red; font-size: 0.8em; }

div.container { margin: 0 auto; width: 940px; }

a { text-decoration: none; }
a:hover { text-decoration: underline; }

h1 { border-bottom: 1px solid #eee; padding-bottom: 13px; }
h1 small { font-size: 0.6em; color: #ccc; }

div.alert { border-radius: 4px; margin: 5px 0; padding: 8px; background-color: #dff0d8; color: #468847; }
	
	

.input-append, .input-prepend {
        font-size:10px;
}
	</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>Add User</title>
		

<script>		
function successHandler(response){
	alert("Successfully created with id "+response);	
}
</script>
	</head>
	<body>

	
	<div class="container" style="padding-top: 50px;">
	
			<div class="well">
	
<htmlf:form legend="Customer Details" formUrl="customerForm" modelAttribute="customerForm"  id="add-user-form" >	
			<htmlf:inputField name="name" label="Name"></htmlf:inputField>
			<htmlf:inputField name="surname" label="Surname" ></htmlf:inputField>
			<htmlf:inputField name="address1Line1" label="Address 1 L1" ></htmlf:inputField>
    		<htmlf:inputField name="address1Line2" label="Address 1 L2" ></htmlf:inputField>
    		<htmlf:inputField name="address1City" label="Address 1 City" ></htmlf:inputField>
    		<htmlf:inputField name="address1Country" label="Address 1 Country" ></htmlf:inputField>
    		<htmlf:inputField name="address2Line1" label="Address 2 Line 1" ></htmlf:inputField>
    		<htmlf:inputField name="address2Line2" label="Address 2 Line 2" ></htmlf:inputField>
    		<htmlf:inputField name="address2City" label="Address 2 City" ></htmlf:inputField>
			<htmlf:inputField name="address2Country" label="Address 2 Country" ></htmlf:inputField>
			<htmlf:inputField name="currentAccountOpeningBalance" label="Current Balance" ></htmlf:inputField>
			<htmlf:inputField name="savingsAccountOpeningBalance" label="Savings Balance" ></htmlf:inputField>
			<div class="form-actions">
						<button type="submit" class="btn btn-primary">Save changes</button>
						<button type="reset" class="btn">Cancel</button>
					</div>
	</htmlf:form>
	</div>
	</div>  
	
		<htmlf:formPartialRefresh  formName="add-user-form" successHandler="successHandler"/>
	
</body>
</html>
