<%@page import="model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create course</title>
</head>
<body>
<p>1</p>
	<%
		List<Course> courseList = (List<Course>) request.getAttribute("courses");
	%>
	<form action="/qlsvweb/create-class" method="post">
		<label for="fname">ID:</label><br>
	   	<input type="number" id="fname" name="id" value=""><br>
	  	<label for="lname">Name:</label><br>
	  	<input type="text" id="lname" name="name" value=""><br>
	  	<label for="lname">Name:</label><br>
	  	<select name="course_id">
	  		<% for (Course c : courseList) { %>
	  			<option value="<%=c.getId()%>"><%=c.getName() %></option>
	  		<% } %>
	  	</select><br>
	  	<button type="submit">Create</button>
	</form>
	
	<% 
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
		<p style="color:red;"><%=msg %></p>
	<%
		}
	%>
	
	<a href='/qlsvweb/menu-class'>Quay lai</a>
</body>
</html>