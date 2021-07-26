package com.onlineexam.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class Admin {
	private String name;
	private String phone;
	private static final String SELECT_ALL_ADMIN = "SELECT * FROM ADMIN";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try {
			LoginDao obj = new LoginDao();
			Connection con = obj.connect();
			PreparedStatement st = con.prepareStatement(SELECT_ALL_ADMIN);
			ResultSet rs = st.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("admin_db_values.jsp");
			List<Admin> list = new ArrayList<>();
			while(rs.next()){
				this.setName(rs.getString("name"));
				this.setPhone(rs.getString("phone_no"));
				list.add(this);
			}
			req.setAttribute("list",list);
			rd.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
