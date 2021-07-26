<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineexam.main.*" import = "java.sql.*" import = "java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent.jsp">
<button>Add Student</button></form>
	<%!
		private static final String SELECT_ALL_STUDENT = "SELECT * FROM STUDENT";
	%>
	<%
		LoginDao obj = new LoginDao();
		Connection con = obj.connect();
		PreparedStatement st = con.prepareStatement(SELECT_ALL_STUDENT);
		ResultSet rs = st.executeQuery();
		RequestDispatcher rd = request.getRequestDispatcher("student_db.jsp");
		while(rs.next()){
			request.setAttribute("name", rs.getString("name"));
			request.setAttribute("id", rs.getInt("id"));
			request.setAttribute("DOB", rs.getString("DOB"));
			request.setAttribute("phone", rs.getString("phone_no"));
	%>
		<c:out value = "${name}"/>
		<form action="deleteStudent">
			<input type="hidden" name="id" value="<%= request.getAttribute("id") %>" />
			<button>Delete</button>
		</form>
		<form action="updateStudent.jsp">
			<button>Update</button>
		</form>
	<%
		}
	%>
</html>