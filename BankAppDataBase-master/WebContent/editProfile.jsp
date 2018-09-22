<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit profile</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%@ include file="footer.jsp" %>
	<form action="editProfile.do" method="post">
	
		<label>Email Id:</label>
		<input type="text" name="email" value="${sessionScope.customer.email}"/>
		<br>
			
		<label>Address:</label>
		<input type="text" name="address" value="${sessionScope.customer.address}"/>
		<br>
			
		<input type="submit" value="submit">
		
	</form>
</body>
</html>