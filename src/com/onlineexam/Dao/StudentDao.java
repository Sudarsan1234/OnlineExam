package com.onlineexam.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineexam.bean.*;
public class StudentDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/examdb?useSSL=false";
	private String Student = "root";
	private String pass = "2411";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_Student_SQL = "INSERT INTO student" + "(name, phone_no, DOB, password) VALUES" + "(?, ?, ?, ?);";
	private static final String SELECT_Student_BY_ID = "SELECT id, name, phone_no, DOB FROM student WHERE id = ?;";
	private static final String SELECT_ALL_Student = "SELECT * FROM student;";
	private static final String DELETE_Student_SQL = "DELETE FROM student WHERE id = ?;";
	private static final String UPDATE_Student_SQL = "UPDATE student SET name = ?, phone_no = ?, DOB = ? where id = ?;";

	protected Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, Student, pass);
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
	public void insertStudent(Student student){
		System.out.println(INSERT_Student_SQL);
		try {
			Connection con = getConnection();
			PreparedStatement prst= con.prepareStatement(INSERT_Student_SQL);
			prst.setString(1, student.getName());
			prst.setString(2, student.getPhone());
			prst.setString(3, student.getDOB());
			prst.setString(4, student.getDOB());
			System.out.println(prst);
			prst.executeUpdate();
			specialFunction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// select Student by id
	public Student selectStudent(int id){
		Student Student = null;
		try{
			Connection con = getConnection();
			PreparedStatement prst = con.prepareStatement(SELECT_Student_BY_ID);
			prst.setInt(1, id);
			System.out.println(prst);
			ResultSet rs = prst.executeQuery();
			while(rs.next()){
				Student = new Student(id, rs.getString("name"), rs.getString("email"), rs.getString("country"));
			}
		}catch(SQLException e){
			printSQLException(e);
		}
		return Student;
	}
	// select all Student
	public List<Student> selectAllStudents(){
		List<Student> Students = new ArrayList<>();
		try{
			Connection con = getConnection();
			PreparedStatement prst = con.prepareStatement(SELECT_ALL_Student);
			System.out.println(prst);
			ResultSet rs = prst.executeQuery();
			while(rs.next()){
				Students.add(new Student(rs.getString("name"), rs.getString("phone_no"), rs.getString("country")));
			}
		}catch(SQLException e){
			printSQLException(e);
		}
		return Students;
	}
	// update Student
	public boolean updateStudent(Student Student) throws SQLException{
		boolean rowUpdated;
		Connection con = getConnection();
		PreparedStatement prst = con.prepareStatement(UPDATE_Student_SQL);
		System.out.println("updateStudent: " + prst);
		prst.setString(1, Student.getName());
		prst.setString(2, Student.getPhone());
		prst.setString(3, Student.getDOB());
		prst.setInt(4, Student.getId());
		rowUpdated = prst.executeUpdate() > 0;
		return rowUpdated;
	}
	// delete Student
	public boolean deleteStudent(int id) throws SQLException{
		boolean rowDeleted;
		Connection con = getConnection();
		PreparedStatement prst = con.prepareStatement(DELETE_Student_SQL);
		System.out.println("deleteStudent: " + prst);
		prst.setInt(1, id);
		rowDeleted = prst.executeUpdate() > 0;
		specialFunction();
		return rowDeleted;
	}
	public void specialFunction() throws SQLException{
		Connection con = getConnection();
		PreparedStatement prst = con.prepareStatement(DELETE_Student_SQL);
		prst = con.prepareStatement("SET @num=0;");
		prst.execute();
		prst = con.prepareStatement("UPDATE student SET id = @num := (@num + 1);");
		boolean res =  prst.executeUpdate() > 0;
		prst = con.prepareStatement("ALTER TABLE student AUTO_INCREMENT;");
		res = res & prst.executeUpdate() > 0;
		if(res){
			System.out.println("Special Function executed successfully!!!");
		}
		else{
			System.out.println("Special Function didn't execute!!");
		}
	}
}
