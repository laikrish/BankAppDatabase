<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="white" style=text-align:center>
<%@ include file="footer.jsp" %>
<form action="changePassword.do" method="post">
<br><br><br><br><br>
<label>Old Password</label>
<input type="password"name="oldPassword" required/>
<br><br><br><br><br>
<label>New Password</label>
<input type="password"name="newPassword" required/>
<br><br><br><br><br>
<label>Confirm Password</label>
<input type="password"name="confirmNewPassword" required/>
<br><br><br><br><br>
<input type="submit" value="Change Password"/>
</form>
</html>