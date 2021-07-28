<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineexam.Dao.*" import = "java.sql.*" import = "java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onclick="window.location.href='admin_dashboard.html';">Back</button>
<form action="addSubject.jsp">
<button>Add Subject</button>
</form>
	<%!
		private static final String SELECT_ALL_SUBJECT = "SELECT * FROM subjects";
	%>
	<%
		LoginDao obj = new LoginDao();
		Connection con = obj.connect();
		PreparedStatement st = con.prepareStatement(SELECT_ALL_SUBJECT);
		ResultSet rs = st.executeQuery();
		RequestDispatcher rd = request.getRequestDispatcher("subject.jsp");
		while(rs.next()){
			request.setAttribute("sname", rs.getString("sname"));
			request.setAttribute("sid", rs.getInt("sid"));
	%>
		<c:out value = "${sname}"/>
		<form action="deleteSubject">
			<input type="hidden" name="sid" value="<%= request.getAttribute("sid") %>" />
			<button>Delete</button>
		</form>
	<%
		}
	%>
</html>