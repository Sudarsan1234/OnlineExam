package com.onlineexam.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.onlineexam.Dao.StudentDao;
import com.onlineexam.bean.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String DOB = request.getParameter("DOB");
		String phone = request.getParameter("phone");
		Student student = new Student(name, DOB, phone);
		StudentDao obj = new StudentDao();
		obj.insertStudent(student);
		RequestDispatcher rd = request.getRequestDispatcher("student_db.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
