<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.onlineexam.main.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent" method = "post">
	<table>
		<tr>
			<th>Name</th>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<th>DOB(YYYY-MM-DD)</th>
			<td>
				<input type="text" name="DOB">
			</td>
		</tr>
		<tr>
			<th>Phone Number</th>
			<td>
				<input type="text" name="phone">
			</td>
		</tr>
		<tr>
			<td><input type = "submit" value="Add"></td>
		</tr>
	</table>
</form>
</body>
</html>