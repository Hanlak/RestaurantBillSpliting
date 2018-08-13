<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/NewProj/getTable" method="post">
Table Number:
<select name ="tableno">
<option value ="1">Table1</option>
<option value ="2">Table2</option>
<option value ="3">Table3</option>
<option value ="4">Table4</option>
<option value ="5">Table5</option>
</select>
${ fail }
<input type="submit" value="submit" />
</form>

</body>
</html>