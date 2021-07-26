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
	<%!
		private String name;
		private String phone;
		private static final String SELECT_ALL_ADMIN = "SELECT * FROM ADMIN";
	%>
	<%
		LoginDao obj = new LoginDao();
		Connection con = obj.connect();
		PreparedStatement st = con.prepareStatement(SELECT_ALL_ADMIN);
		ResultSet rs = st.executeQuery();
		RequestDispatcher rd = request.getRequestDispatcher("admin_db_values.jsp");
		while(rs.next()){
			name = rs.getString("name");
			phone = rs.getString("phone_no");
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
	%>
		<c:out value = "${name}"/> <c:out value = "${phone}"/><br>
	<%
		}
	%>
</html>