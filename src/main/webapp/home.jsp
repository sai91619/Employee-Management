<%@page import="java.util.List"%>
<%@page import="spring_mvc3.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Employee> em=(List<Employee>)request.getAttribute("home");
if(em!=null){
for(Employee e:em){%>
<%=e.getId()%><br>
<%=e.getName()%><br>
<%=e.getEmail() %><br>
<%=e.getPhone() %><br>
<a href="update?id=<%=e.getId()%>"><button>Update</button></a>
<a href="delete?id=<%=e.getId()%>"><button>Delete</button></a><br><br>
<%}} %>
</body>
</html>