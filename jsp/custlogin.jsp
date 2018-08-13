<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>Customer Login</h1>	<!-- Login Module for Customers -->
	<form action = "/NewProj/custsubmit" accept-charset="utf-8" method = "post"><br><br><br><br>
	UserName:
	<input type = "text" name ="username"><br><br><br>
	password:
	<input type= "password" name = "password">
	<div class= "alert alert-danger">
	<h5> ${msg} </h5>
	</div>
	<input type ="submit" value ="Login">
	</form>
</body>
</html>