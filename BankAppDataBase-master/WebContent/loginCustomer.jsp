<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="marble" >


<%@ include file="header.jsp" %>  
<%@ include file="footer.jsp" %> 

	<form action="login.do" method="post">
	
		<label>Customer Id: </label>
		<input type="text" size="15" name = "customerId" required>
		<br>
		
		<label>Password: </label>
		<input type="password" size="15" name = "password" required>
		<br>
	
	
			<input type="submit" value="Log In">
		
	
	</form>
</body>
</html>