<%@page import="model.MyClass"%>
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
	<h1>--Menu Class--</h1>
	<a href='/qlsvweb/create-class'>Create Course</a>
	<%
		List<MyClass> myClassList = (List<MyClass>) request.getAttribute("classes");
	
		for (MyClass c : myClassList) {
			%>
				<p>------------</p>
				<p>ID: <%=c.getId() %></p>
				<p>Name: <%=c.getName() %></p>
				<p>Course: <%=c.getCourse().getName() %></p>
				<a href='/qlsvweb/update-course?id=<%=c.getId() %>&name=<%=c.getName() %>'>Edit Course</a>
				<a href='/qlsvweb/delete-course?id=<%=c.getId()%>'>Delete Course</a>
			<%
		};
	%>
</body>
</html>