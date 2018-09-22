<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="white" style=text-align:center>
<form action="transferAmount" method="post">
	<br><br><br>
	<label> From Account: </label>
		<input type="text" value="${customer.customerAccount.accountId}" name="fromAccId" readonly/>
		<br> <br>
	<label> To Account: </label>
		<input type="text" name="toAccId" required/>
		<br> <br>
	<label> Amount: </label>
		<input type="number"  name="amount" min=1000 max=10000 required/>
		<br> <br>
		<input type="reset" value="Clear"/>
	<input type="submit" value="Submit"/>
	<br>
	</form>

</body>
</html>