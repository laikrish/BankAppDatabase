<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Updated successfully</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<div class="container">
		<%-- <table class="table" border=1>
					<tr>
						<th>Customer Name</th>
						<th>Customer Id</th>
						<th>Customer Email</th>
						<th>Customer Address</th>
						<th>Customer DOB</th>
						
						
					</tr>
					<tr>
						<td>${sessionScope.customer.customerName}</td>
						<td>${sessionScope.customer.customerId}</td>
						<td>${sessionScope.customer.email}</td>
						<td>${sessionScope.customer.address}</td>
						<td>${sessionScope.customer.dateOfBirth}</td>
						
						
					</tr>
		</table> --%>	
		
		<h1>Updated Successfully</h1>
	</div>
</body>
</html>