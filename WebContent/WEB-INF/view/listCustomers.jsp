<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/basicStyle.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/listCustomersStyle.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- Add button for adding customer -->
			<input type="button" class="basic-button" value="Add Customer"
				onClick="window.location.href='add'; return false;" />

			<!-- Add table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- Iterate over the customers and print each customer info -->
				<c:forEach var="customer" items="${customers}">

					<!-- Construct url with the customer ID for updating each customer -->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="customerID" value="${customer.id}" />
					</c:url>

					<!-- Construct url with the customer ID for deleting each customer -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerID" value="${customer.id}" />
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<!-- Add link to update customer --> <a href="${updateLink}"
							title="update" class="fas fa-pen" id="update-icon"> </a> <!-- Add link to delete customer -->
							<a href="${deleteLink}" onclick="getConfirmation(event)"
							title="delete" class="fas fa-trash-alt" id="delete-icon"> </a> <!-- Display confirmation box before deleting a customer -->
							<script>
								function getConfirmation(event) {
								  if (confirm('Are you sure you want to delete this customer?')) {
									  return true;
								  }
								  else{
									  event.preventDefault();
									  return false;
								  }
								}
								</script>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>