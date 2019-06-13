<html>
<body>
<%

String message=(String)session.getAttribute("key");

if(message==null)
{
boolean b=true;
}
else
{
out.print(message);
}

%>



<h2 align="center">Welcome to Mobile Banking</h2>
<form action="BankApplication" method="post">
<table align="center">
<tr>
<td>User name:</td>
<td><input type="text" name="uname"><br>
</td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td><a href="newuser.jsp">New User</a></td>
<td><a href="forgot.jsp">Forgot Password</a></td>
</tr>
<tr>
<td><input type="submit"  value="Submit" name="submit"></td>
<td><input type="reset" value="Reset"></td>
</tr></table>
</form>
</body>
</html>
