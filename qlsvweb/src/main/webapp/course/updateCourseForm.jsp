<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='/qlsvweb/menu-course'>Quay lai</a>
	<%
		String idString = request.getParameter("id");
		String nameString = request.getParameter("name");
	%>
	<form action="/qlsvweb/update-course" method="post">
		<label>Id:</label><br>
		<input type="number" name="id" value='<%=idString%>'><br>
		<label>Name:</label><br>
		<input type="text" name="name" value='<%=nameString%>'><br>
		<button type="submit">Save</button>
	</form>
	
	<% 
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
		<p style="color:red;"><%=msg %></p>
	<%
		}
	%>
</body>
</html>