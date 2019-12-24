package com.pm.springboot.curd.springbootcurd.entity;

import java.sql.Timestamp;

public class StudentNotFoundError {
	
	private long status;
	private String message;
	private long currenttime;
	
	
	
	
	
	public StudentNotFoundError(long status, String message, long currenttime) {
		this.status = status;
		this.message = message;
		this.currenttime = currenttime;
	}
	public StudentNotFoundError() {
		// TODO Auto-generated constructor stub
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(long currenttime) {
		this.currenttime = currenttime;
	}
	
	
	
	

}
