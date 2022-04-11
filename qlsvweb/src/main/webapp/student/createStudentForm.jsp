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
	<form action="/qlsvweb/create-student" method="post">
		<label for="fname">ID:</label><br>
	   	<input type="number" id="fname" name="id" value=""><br>
	  	<label for="lname">Name:</label><br>
	  	<input type="text" id="lname" name="name" value=""><br>
	  	<label for="fname">Age:</label><br>
	   	<input type="number" id="fname" name="age" value=""><br>
	  	<label for="lname">Birthday:</label><br>
	  	<input type="date" id="lname" name="birthdate" value=""><br>
	  	<label for="fname">Code:</label><br>
	   	<input type="number" id="fname" name="code" value=""><br>
	  	<label for="lname">Sex:</label><br>
	  	<input type="text" id="lname" name="sex" value=""><br>
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
	
	<a href='/qlsvweb/menu-student'>Quay lai</a>
</body>
</html>