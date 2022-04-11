<%@page import="model.Student"%>
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
	<h1>--Menu Student--</h1>
	<a href='/qlsvweb/create-student'>Create Student</a>
	<%
		List<Student> studentList = (List<Student>) request.getAttribute("students");
	
		for (Student c : studentList) {
			%>
				<p>------------</p>
				<p>ID: <%=c.getId() %></p>
				<p>Name: <%=c.getName() %></p>
				<p>Age: <%=c.getAge() %></p>
				<p>Birthday: <%=c.getBirthdate() %></p>
				<p>Code: <%=c.getCode() %></p>
				<p>Sex: <%=c.getSex() %></p>
				<a href='/qlsvweb/update-student?id=<%=c.getId() %>&name=<%=c.getName() %>'>Edit Student</a>
				<a href='/qlsvweb/delete-student?id=<%=c.getId()%>'>Delete Student</a>
			<%
		};
	%>
</body>
</html>