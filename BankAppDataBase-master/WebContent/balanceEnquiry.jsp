<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
</head>
<body>

<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<h3>Your ${sessionScope.customer.bankAccount.accountType} account clear balance is: ${sessionScope.customer.bankAccount.balance}</h3>

</body>
</html>