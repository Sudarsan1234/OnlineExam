<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineexam.bean.*" import="com.onlineexam.Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "updateStudent" method="post">
		<%
			int id = Integer.parseInt(request.getParameter("id"));
			StudentDao obj = new StudentDao();
			Student st = obj.selectStudent(id);
			Cookie c = new Cookie("name", st.getName());
			response.addCookie(c);
			c = new Cookie("id", st.getId()+"");
			response.addCookie(c);
			c = new Cookie("phone", st.getPhone());
			response.addCookie(c);
			c = new Cookie("DOB", st.getDOB());
			response.addCookie(c);
		%>
		<table>
			<tr>
				<th>ID: </th>
				<td><input type="text" name="id" value="<%= st.getId()%>" disabled/></td>
			</tr>
			<tr>
				<th>Name: </th>
				<td><input type="text" name="name" value="<%= st.getName()%>" disabled/></td>
			</tr>
			<tr>
				<th>DOB: </th>
				<td><input type="text" name="DOB" value="<%= st.getDOB()%>"/></td>
			</tr>
			<tr>
				<th>Phone: </th>
				<td><input type="text" name="phone" value="<%= st.getPhone()%>"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>