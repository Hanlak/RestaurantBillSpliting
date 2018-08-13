<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
<body style="text-align:center">
	<h1>Restaurant Login</h1>
	<form action = "/NewProj/restsubmit" method = "post"><br><!--Login Form for Restaurant Owners-->
	UserName:
	<input type = "text" name ="username"><br>
	password:
	<input type= "password" name = "password">
	<div class= "alert alert-danger">
	<h5> ${msg} </h5>
	</div>
	<input type ="submit" value ="Login">
	</form>
</body>
</html>