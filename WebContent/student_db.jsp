<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineexam.bean.*" import="com.onlineexam.Dao.*" import = "java.sql.*" import = "java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onclick="window.location.href='admin_dashboard.html';">Back</button>
<form action="addStudent.jsp">
<button>Add Student</button>
</form>
	<%!
		private static final String SELECT_ALL_STUDENT = "SELECT * FROM STUDENT";
	%>
	<%
		StudentDao obj = new StudentDao();
		List<Student> list = obj.selectAllStudents();
		for(Student st:list){
	%>
		<c:out value = "<%= st.getName() %>"/>
		<c:out value = "<%= st.getDOB() %>"/>
		<c:out value = "<%= st.getPhone() %>"/>
		<form action="deleteStudent">
			<input type="hidden" name="id" value="<%= st.getId() %>" />
			<button>Delete</button>
		</form>
		<form action="updateStudent.jsp">
			<input type="hidden" name="id" value="<%= st.getId() %>" />
			<button>Update</button>
		</form>
	<%
		}
	%>
</html>