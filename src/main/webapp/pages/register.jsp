<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
</head>
<body>
<form action="Register" method="post"> 
<%@include file="base.jsp" %>
<%@ include file="navigation.jsp" %>

<div class="row justify-content-center">
<div class ="col-md-6">
<div class="card">
<div class="card-body">
<h3 class="card-title">Register here</h3>
<p class="card-text">
<form class="form-group">
<label for="name">Name  </label><br>
<input type="text" class="form-control" placeholder="Enter your name"><br>
<label for="email">Email :  </label><br>
<input type="text" class="form-control" placeholder="Enter your email"><br>
<label for="bdate">DOB :  </label><br>
<input type="date" class="form-control" placeholder="Enter your dob"><br>
<label class="form-label" for="gender">Gender  </label><br>
<input type="radio" name="gender" value="Male" >Male
<input  type="radio" name="gender" value="Female" >Female<br>
<label for="password">Create Password : </label><br>
<input type="text" class="form-control" type="password" placeholder="your  password"><br><br>
<button class="btn btn-primary" type="Submit">Register</button></form>
</div></div>
</div></div></form>
</body>
</html>