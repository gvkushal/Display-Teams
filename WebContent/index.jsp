<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action= "login" method="post" onclick="validateForm()">
<!-- <input type="hidden" name="request_type" value="login"/> -->
<input type=hidden name='request_type' value='login' />
UserName </br><input type = "text" name = "username" /></br>
Password </br><input type = "password" name = "password" /></br>
<button type="button" value="signup" onClick="location.href='Signup.jsp'">signup</button>
<button type="submit" value="login" float=left> login </button>
</form>
<p id="info"></p>
<script>
function validateForm()
{
	document.getElementById("info").innerText="Hello";
	return false;
}</script>
</body>
</html>