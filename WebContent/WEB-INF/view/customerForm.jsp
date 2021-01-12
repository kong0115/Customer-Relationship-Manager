<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Save Customer</title>
		<link type="text/css" rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/basicStyle.css">
		<link type="text/css" rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/addCustomerStyle.css">
	</head>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list" > 
					&#60;&#60; Back to Customers List
				</a>
			</p>
			
			<form:form action="processCustomerForm" modelAttribute="customer" method="POST">
				
				<!-- Need to associate this data with customer id -->
				<form:hidden path="id" />
				<table>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>						
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>							
					</tr>	
					
					<tr>
						<td></td>
						<td><input type="submit" value="Save" onclick="getConfirmation(event)" class="basic-button"/></td>						
					</tr>						
																	
				</table>
				<!-- Display confirmation box before saving a customer -->
				<script>
				function getConfirmation(event) {
					if (confirm('Are you sure you want to save this customer?')) {
						return true;
					}
					else{
						event.preventDefault();
						return false;
					}
				}
				</script>				
			</form:form>
		</div>		
		
	<body>
	</body>
</html>
