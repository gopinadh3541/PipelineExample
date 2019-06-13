<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankApplication" method="get">
<table align="center">
<tr>
<td>Account Number</td>
<td><input type="text" name="accnumber" pattern="[1-9]{1}[0-9]{9}">[must use 10 numbers]</td>
</tr>
<tr>
<td>Bank Name</td>
<td><input type="text" name="name" pattern="[a-zA-Z]{3,}">[use Alphabets more than 3]</td>
</tr>
<tr>
<td>Enter Amount</td>
<td><input type="text" name="amount" pattern="[1-9]{1}[0-9]{2,4}">[Enter less than 1 lakh]</td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="reset"></td>
</tr></table>
</form>
</body>
</html>