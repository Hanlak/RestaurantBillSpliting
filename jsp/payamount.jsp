<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PAYMENT CHOOSE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#pc").click(function(){
    	$(".paybycard").hide();
    	$(".paybycash").show(); 
    });
    $("#pcd").click(function(){
    	$(".paybycash").hide();
        $(".paybycard").show();
        
    });
});
</script>
<style>
.paybycash{
display:none;
}
.paybycard{
display:none;
}
</style>
</head>
<body>
<br>
<center>
<table>
<tr>
<th>AMOUNT TO BE PAID:</th>
<th> ${amount} </th>
</tr></table>
<br>
<div class ="container">
<button id ="pc" class = "btn btn-primary" >PAY BY CASH</button>&nbsp; &nbsp; &nbsp; &nbsp;<button id ="pcd" class="btn btn-primary" >PAY BY CARD</button>
</div>
</center>
<div class ="container">
<div class ="paybycash">
<form action ="/NewProj/payByCash" method = "post">
<label>AMOUNT PAYING</label>
<input type ="text" name ="bill" class ="form-control"><br>
<input type ="submit" class = "btn btn-primary" value ="Pay By Cash" >
</form>
</div>
<div class ="paybycard">
<form action ="/NewProj/payByCard" method="post">
<label>Amount</label>
<input type="text" name ="amount" class ="form-control">
 <label>Enter The Card Number</label><input type ="text" class ="form-control" name ="cardnumber" >
 <label>CVV:</label>
<input type="text" name ="cvv" class ="form-control" ><br>
<input type ="submit" class = "btn btn-primary" value ="Pay By Cash" >
</form>
</div>
 ${fail}
</div>
</body>
</html>