<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String s= (String)request.getAttribute("register");
if(s!=null){%>
<%=s %>
<%} %>
<form action="save">
<fieldset>
<legend>Registration form</legend>
<label for="name">Name:</label>
<input type="text" id=name name=name placeholder="Enter your name"><br><br>
<label for="email">EMail:</label>
<input type="email" id=email name=email placeholder="Enter your email"><br><br>
<label for="pwd">Password:</label>
<input type="Password" id=pwd name=pwd placeholder="Enter your password"><br><br>
<label for="phone">Phone:</label>
<input type="tel" id=phone name=phone placeholder="Enter your number"><br><br>
<button>Submit</button>
</fieldset>
</form>
</body>
</html>