<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String s= (String) request.getAttribute("login");
if(s!=null){%>
<%=s %>
<%} %>
<form action="login">
<fieldset>
<legend>Login</legend>
<label for="email">Email Id:</label>
<input type="text" id="email" placeholder="Enter your email id" name="email"><br><br>
<label for="pwd">password</label>
<input type="password" id="pwd" placeholder="Enter your password" name="pwd">
<button>Login</button>
<label></label>
</fieldset>
</form>
</body>
</html>