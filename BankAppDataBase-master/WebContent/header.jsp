<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	     <img src="images/icicilogo.jpg" width="300" height="120"/>
	    </div>
	    <ul class="nav navbar-nav">
	    <c:if test="${sessionScope.customer.customerId==null}">
	      <li class="active"><a href="index.jsp">Home</a></li>
	     </c:if>
	  
	      <c:if test="${sessionScope.customer.customerId==null}">
	      	<li><a href="loginCustomer.jsp">Login</a></li>
	      </c:if>
	      <c:if test="${sessionScope.customer.customerId!=null}">
	      	<li><a href="balanceEnquiry.jsp">Balance inquiry</a></li>
	      </c:if>
	      <c:if test="${sessionScope.customer.customerId!=null}">
	      	<li><a href="fundTransfer.jsp">Fund Transfer</a></li>
	      </c:if>
	      	
	      <c:if test="${sessionScope.customer.customerId!=null}">
	      	<li><a href="changePassword.jsp">Change Password</a></li>
	      </c:if>
	      
	      <c:if test="${sessionScope.customer.customerId!=null}">
	      	<li><a href="editProfile.jsp">Edit Profile</a></li>
	      </c:if>
	      
	      
	    </ul>
	  <ul class="nav navbar-nav navbar-right">
	 	<c:if test="${sessionScope.customer.customerName!=null}">
     		<li><a href="displayDetails.jsp"><span class="glyphicon glyphicon-user">${sessionScope.customer.customerName}</span></a></li>
		</c:if>
	  	<c:if test="${sessionScope.customer.customerName!=null}">
     		<li><a href="logout.do"><span class="glyphicon glyphicon-user"></span>Log out</a></li>
		</c:if>
	      
	      
	    </ul>
	  </div>
	</nav>
	  

</body>
</html>