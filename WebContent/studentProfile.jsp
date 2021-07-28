<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineexam.bean.*" import="com.onlineexam.Dao.*"  import="com.onlineexam.main.*"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<button onclick = "redirect(event);">Back</button><br>
    <%!
		private String name;
		private String phone;
		private int id = CommonSession.get();
	%>
	<%
		StudentDao obj = new StudentDao();
		Student student = obj.selectStudent(id);
		request.setAttribute("id", id);
		request.setAttribute("name", student.getName());
		request.setAttribute("DOB", student.getDOB());
		request.setAttribute("phone", student.getPhone());
	%>
		<c:out value = "${id}"/> <c:out value = "${name}"/> <c:out value = "${phone}"/> <c:out value = "${DOB}"/><br>
</body>
<script>
	function redirect(event){
		window.location.href = "student_dashboard.html";
	}
</script>
</html>