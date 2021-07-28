package com.onlineexam.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineexam.Dao.StudentDao;
import com.onlineexam.bean.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null, phone = null, DOB = null;
		int id = 0;
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies){
			if(c.getName().equals("name"))
				name = c.getValue();
			if(c.getName().equals("id"))
				id = Integer.parseInt(c.getValue());
			if(c.getName().equals("phone"))
				phone = c.getValue();
			if(c.getName().equals("DOB"))
				DOB = c.getValue();
		}
		System.out.println(DOB + " " + phone);
		Student st = null;
		if(!DOB.equals(request.getParameter("DOB")))
			DOB = request.getParameter("DOB");
		if(!phone.equals(request.getParameter("phone")))
			phone = request.getParameter("phone");
		System.out.println(DOB + " " + phone);
		st = new Student(id, name, DOB, phone);
		StudentDao obj = new StudentDao();
		try {
			obj.updateStudent(st);
			System.out.println("Tuple Updated Successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
