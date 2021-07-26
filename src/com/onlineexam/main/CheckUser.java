package com.onlineexam.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao obj;
	private RequestDispatcher rd;
	private String admin = "Admin";
	private String student = "Student";
	private String fail = "false";
	public void init(){
		obj = new LoginDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			String returnedString = obj.check(username, password);
			if(returnedString.equals(admin)){
				System.out.println("Login Successful!!!!");
				rd = request.getRequestDispatcher("admin_dashboard.html");
				rd.forward(request, response);
			}
			if(returnedString.equals(student)){
				System.out.println("Login Successful!!!!");
				rd = request.getRequestDispatcher("student_dashboard.html");
				rd.forward(request, response);
			}
			if(returnedString.equals(fail)){
				PrintWriter out = response.getWriter();
				System.out.println("Login UnSuccessful!!!!");
				out.println("Login UnSuccessful!!!!");
				rd = request.getRequestDispatcher("login1.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		finally{
//			OutputStream o = response.getOutputStream();
//			o.close();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
