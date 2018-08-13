<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
</head>
<body>
<div class="container">
 <table class="table">
    <thead>
      <tr>
        <th>TABLE NO</th>
        <th>BILL AMOUNT</th>
        <th>BILL STATUS</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${map}" var="list">
    <tr>
        <c:forEach items="${list}" var="entry">
   	<c:if test ="${entry.key=='tablename' }">
   	<td>${entry.value}</td>
     </c:if>

    	<c:if test ="${entry.key=='billamount' }">
    	<c:choose >
    	<c:when test ="${entry.value =='0' || entry.value=='0.0' }">
    	<td>${ entry.value}</td>
    	<td>PAID</td>
    	</c:when>
    	<c:otherwise>
    	<td>${ entry.value}</td>
    	<td>NOT PAID</td>
    	</c:otherwise>
    	</c:choose>
     </c:if>
        </c:forEach>
    </tr>
</c:forEach>
    </tbody>
  </table>
 
</div>
<a href ="/NewProj/">CLICK HERE TO GO HOME</a>
</body>
</html>