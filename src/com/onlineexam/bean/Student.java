package com.onlineexam.bean;

public class Student {
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String dOB, String phone) {
		super();
		this.name = name;
		DOB = dOB;
		this.phone = phone;
	}
	public Student(int id, String name, String dOB, String phone) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.phone = phone;
	}
	private String name;
	private String DOB;
	private String phone;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPhone() {
		return phone;
	}
	public int getId() {
		return id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
