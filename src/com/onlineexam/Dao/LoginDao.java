package com.onlineexam.Dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private int id;
	public Connection connect() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.println("Error:" + e);
		}
		final String s = "jdbc:mysql://localhost:3306/examdb";
		final String user = "root";
		final String pass = "2411";
		Connection con = DriverManager.getConnection(s,user,pass);
		System.out.println("Connected");
		return con;
	}
	public void insertDB(String username, String password) throws ClassNotFoundException, SQLException{
		Connection con = connect();
		String sql = "insert into user_info(username, password) values(?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,username);
		st.setString(2, password);
		st.execute();
		System.out.println("Row Affected!!!!");
		st.close();
		con.close();
	}
	public int getID(){
		return id;
	}
	public String check(String username, String password) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		String admin = "Admin";
		String student = "Student";
		String fail = "false";
		Connection con = connect();
		PreparedStatement st = con.prepareStatement("SELECT * FROM admin;");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
				id = rs.getInt("id");
				st.close();
				con.close();
				System.out.println("Admin Login");
				return admin;
			}
		}
		st = con.prepareStatement("SELECT * FROM student;");
		rs = st.executeQuery();
		while(rs.next()){
			if(rs.getString("name").equals(username) && rs.getString("password").equals(password)){
				id = rs.getInt("id");
				st.close();
				con.close();
				System.out.println("Student Login");
				return student;
			}
		}
		return fail;
	}
}
