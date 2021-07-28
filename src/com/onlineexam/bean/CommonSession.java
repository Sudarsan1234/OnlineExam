package com.onlineexam.bean;
import javax.servlet.http.*;
public class CommonSession extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int id;
	private static Student std;

	public static int get() {
		return id;
	}

	public static void set(int id) {
		CommonSession.id = id;
	}
	public static Student getSt() {
		return std;
	}

	public static void setSt(Student st) {
		CommonSession.std = st;
	}
}
