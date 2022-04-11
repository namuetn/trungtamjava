<%@page import="model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>--Menu Course--</h1>
	<a href='/qlsvweb/create-course'>Create Course</a>
	<%
		List<Course> courseList = (List<Course>) request.getAttribute("courses");
	
		for (Course c : courseList) {
			%>
				<p>------------</p>
				<p>ID: <%=c.getId() %></p>
				<p>Name: <%=c.getName() %></p>
				<a href='/qlsvweb/update-course?id=<%=c.getId() %>&name=<%=c.getName() %>'>Edit Course</a>
				<a href='/qlsvweb/delete-course?id=<%=c.getId()%>'>Delete Course</a>
			<%
		};
	%>
</body>
</html>