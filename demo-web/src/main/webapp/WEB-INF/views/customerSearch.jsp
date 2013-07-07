<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:form="http://www.springframework.org/tags/form">

<%@ taglib prefix="htmlf" tagdir="/WEB-INF/tags"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/form.js" ></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<style>

.input-append, .input-prepend {
        font-size:10px;
}
</style>

<head>

<script type="text/javascript">

$(document).ready(function() {
	jQuery(function($) {
		$('.btn-group[data-toggle]').each(function() {
			var hidden = $("#searchBy");
			$(this).on('click', '.btn', function() {
				hidden.val($(this).val());
			}).find('.btn').each(function() {
				$(this).toggleClass('active', $(this).val() == hidden.val())
			});
		});
	});
});

function pageController($scope) {
	$scope.searchTerm = "";
	$scope.amount = "";
	$scope.balTo = "";
	$scope.balFrom = [];
	$scope.balFromSelection = 0;
	$scope.balToSelection = 0;
	$scope.customer=undefined;
	
	$scope.updateCustomer = function(customer){
 		$scope.customer = customer;
	 };
	 
	 $scope.updateAccounts = function(el){
		 $scope.balFrom.push(el);
	 }
}
	
function transferSuccessHandler(response){
	alert("Transfer done");	
}

function customerSearchBoxHandler(response){
	
	 $.each(response.accounts, function(i, el) {
			angular.element($('#controller')).scope().updateAccounts(el);
	});
	 	
		
		angular.element($('#controller')).scope().updateCustomer(response);
		angular.element($('#controller')).scope().$apply();
}

</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<htmlf:formPartialRefresh formName="customerSearch" successHandler="customerSearchBoxHandler"/>
<htmlf:formPartialRefresh formName="transferForm" successHandler="transferSuccessHandler"/>

</head>
<body>

<div id="controller" ng-controller="pageController">

<div id="transferBlock" class="container">
	<div class="well">
	
<htmlf:form legend="Customer Search"  modelAttribute="customerSearch" id="customerSearch"  formUrl="customerSearch">
				<htmlf:inputField label="Search Term" ngmodel="searchTerm"  name="searchTerm" icon="icon-user" placeholder="Search term"/>
				<htmlf:radiogroup label="Search By" name="searchBy" items="Customer ID, Name" defaultActive="1"/>
		
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" name="submit" id="submit" class="btn btn-success" ng-disabled="searchTerm == ''">Search</button>
					</div>
				</div>

			</htmlf:form>
</div>
</div>

<div ng-show="customer != undefined" id="transferBlock" class="container">
	<div class="well ">
<legend>Results for {{customer.name}}</legend>
<table class="table table-striped table-bordered table-condensed">
    <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Address 1</th>
        </tr>
    </thead>

    <tbody id="tcbody">
    	<tr><td>{{customer.name}}</td><td>{{customer.surname}}</td><td>{{customer.address1Line1}} (etc. rest of fields easily obtained)</td></tr>
    </tbody>

</table>
<table ng-show="customer != undefined"  class="table table-striped table-bordered table-condensed">
    <thead>
        <tr>
            <th>#</th>
            <th>Transaction Date</th>
            <th>DRCR</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody id="tbody">
    	 <tr ng-repeat="t in customer.customerTransactions"><td>{{t.id}}</td><td>{{t.transactionDate.year}}-{{t.transactionDate.monthOfYear}}-{{t.transactionDate.dayOfMonth}}</td><td>{{t.drcr}}</td><td>{{t.amount}}</td></tr>
    </tbody>
</table>
</div> </div>


	<div ng-show="customer != undefined" id="transferBlock" class="container">
		<div class="well"> 
			<htmlf:form legend="Balance Transfer" modelAttribute="balanceTransfer" id="transferForm"  formUrl="balanceTransfer">
				<htmlf:comboField ngmodel="balFromSelection" label="From" name="sourceAccount" ngoptions="value.id as value.acType for value in balFrom"/>
				<htmlf:comboField ngmodel="balToSelection" label="From" name="targetAccount" ngoptions="value.id as value.acType for value in balFrom"/>
				<htmlf:inputField ngmodel="amount" label="Amount" name="transferAmount" />
				<input type="hidden" name="customerId" id="customerId" value="{{customer.id}}" />
				<input type="hidden" name="sourceAccount"  value="{{balFromSelection}}" />
				<input type="hidden" name="targetAccount" value="{{balToSelection}}" />
							
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" name="submitTransfer" id="submitTransfer" class="btn btn-success" ng-disabled="amount == '' || balFromSelection == balToSelection">Transfer</button>
					</div>
				</div>
				</p> 
			</htmlf:form>
		</div>
	</div>
	</div> 
</div>

</body>
</html>
