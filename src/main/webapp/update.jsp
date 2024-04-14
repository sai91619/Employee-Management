<%@page import="employeemanagement.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Employee e= (Employee)request.getAttribute("update");%>
<form action="edit">
<fieldset>
<legend>Update details</legend>
<label for="id">Id:</label>
<input type="number" id=name name=id value="<%=e.getId()%>" readonly="readonly"><br><br>
<label for="name">Name:</label>
<input type="text" id=name name=name placeholder="Enter your name" value="<%=e.getName()%>"><br><br>
<label for="email">EMail:</label>
<input type="email" id=email name=email placeholder="Enter your email" value="<%=e.getEmail()%>"><br><br>
<label for="pwd">Password:</label>
<input type="Password" id=pwd name=pwd placeholder="Enter your password" value="<%=e.getPwd()%>"><br><br>
<label for="phone">Phone:</label>
<input type="tel" id=phone name=phone placeholder="Enter your number" value="<%=e.getPhone()%>"><br><br>
<button>Submit</button>
</fieldset>
</form>
</body>
</html>