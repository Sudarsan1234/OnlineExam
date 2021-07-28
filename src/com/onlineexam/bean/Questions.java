package com.onlineexam.bean;

public class Questions {
	public Questions(String question, String op1, String op2, String op3, String op4, Character correct_op, Character user_op) {
		super();
		this.question = question;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.correct_op = correct_op;
		this.user_op = user_op;
	}
	public Questions(String question, String op1, String op2, String op3, String op4, Character correct_op) {
		super();
		this.question = question;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.correct_op = correct_op;
	}
	private final String question;
	private final String op1, op2, op3, op4;
	private final Character correct_op;
	private Character user_op;
	public String getQuestion() {
		return question;
	}
	public String getOp1() {
		return op1;
	}
	public String getOp2() {
		return op2;
	}
	public String getOp3() {
		return op3;
	}
	public String getOp4() {
		return op4;
	}
	public Character getCorrect_op() {
		return correct_op;
	}
	public Character getUser_op() {
		return user_op;
	}
}
