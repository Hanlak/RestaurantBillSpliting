<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<form action = "/NewProj/updateBill" method = "post"><br>
Table Number:
<select name ="tableno">
<option value ="1">Table1</option>
<option value ="2">Table2</option>
<option value ="3">Table3</option>
<option value ="4">Table4</option>
<option value ="5">Table5</option>
</select><br>
Bill Amount:
<input type= "text" name = "billamount"><br><br><br><br><br>
<h1> ${ fail } </h1>
<input type= "submit" value="UpdateSplitBills">
</form>
<a href="/NewProj/showpayments"><button>show Payments</button></a>
</body>
</html>