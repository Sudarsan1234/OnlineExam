package com.onlineexam.bean;

public class Subjects {
	public Subjects(String subject) {
		super();
		this.subject = subject;
	}
	public Subjects(int sid, String subject) {
		super();
		this.subject = subject;
		this.setSid(sid);
	}
	
	private String subject;
	private int sid;

	public String getSubject() {
		return subject;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
