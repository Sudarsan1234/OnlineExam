package com.onlineexam.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineexam.bean.*;
public class SubjectDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/examdb?useSSL=false";
	private String user = "root";
	private String pass = "2411";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_SUBJECT_SQL = "INSERT INTO subjects" + "(sname) VALUES" + "(?);";
	private static final String SELECT_SUBJECT_BY_ID = "SELECT Sid, Sname FROM subjects WHERE sid = ?;";
	private static final String SELECT_ALL_SUBJECT = "SELECT * FROM subjects;";
	private static final String DELETE_SUBJECT_SQL = "DELETE FROM subjects WHERE sid = ?;";

	protected Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			printSQLException(e);
		}
		return con;
	}
	
	private void printSQLException(SQLException ex) {
		for( Throwable e:ex){
			if(e instanceof SQLException){
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while(t!=null){
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	//insert Student
	public void insertSubject(Subjects sub){
		System.out.println(INSERT_SUBJECT_SQL);
		try {
			Connection con = getConnection();
			PreparedStatement prst= con.prepareStatement(INSERT_SUBJECT_SQL);
			prst.setString(1, sub.getSubject());
			System.out.println(prst);
			prst.executeUpdate();
			specialFunction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// select Student by id
	public Subjects selectSubject(int sid){
		Subjects sub = null;
		try{
			Connection con = getConnection();
			PreparedStatement prst = con.prepareStatement(SELECT_SUBJECT_BY_ID);
			prst.setInt(1, sid);
			System.out.println(prst);
			ResultSet rs = prst.executeQuery();
			while(rs.next()){
				sub = new Subjects(sid, rs.getString("sname"));
			}
		}catch(SQLException e){
			printSQLException(e);
		}
		return sub;
	}
	// select all Student
	public List<Subjects> selectAllSubjects(){
		List<Subjects> subList = new ArrayList<>();
		try{
			Connection con = getConnection();
			PreparedStatement prst = con.prepareStatement(SELECT_ALL_SUBJECT);
			System.out.println(prst);
			ResultSet rs = prst.executeQuery();
			while(rs.next()){
				subList.add(new Subjects(rs.getString("sname")));
			}
		}catch(SQLException e){
			printSQLException(e);
		}
		return subList;
	}
	// delete Student
	public boolean deleteSubject(int sid) throws SQLException{
		boolean rowDeleted;
		Connection con = getConnection();
		PreparedStatement prst = con.prepareStatement(DELETE_SUBJECT_SQL);
		System.out.println("deleteSubject: " + prst);
		prst.setInt(1, sid);
		rowDeleted = prst.executeUpdate() > 0;
		specialFunction();
		return rowDeleted;
	}
	public void specialFunction() throws SQLException{
		Connection con = getConnection();
		PreparedStatement prst = con.prepareStatement(DELETE_SUBJECT_SQL);
		prst = con.prepareStatement("SET @num=0;");
		prst.execute();
		prst = con.prepareStatement("UPDATE subjects SET sid = @num := (@num + 1);");
		boolean res =  prst.executeUpdate() > 0;
		prst = con.prepareStatement("ALTER TABLE subjects AUTO_INCREMENT;");
		res = res & prst.executeUpdate() > 0;
		if(res){
			System.out.println("Special Function executed successfully!!!");
		}
		else{
			System.out.println("Special Function didn't execute!!");
		}
	}
}
