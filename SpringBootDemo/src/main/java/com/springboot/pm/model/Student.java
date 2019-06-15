package com.springboot.pm.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class Student {
	
	private int id;
	private String userName;
    private String PASSWORD;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String emailAddress;
    private boolean submitted;
	
    
    public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	public Student(int id, String userName, String pASSWORD, String firstName, String lastName, String dateOfBirth,
			String emailAddress,boolean submitted) {
		super();
		this.id = id;
		this.userName = userName;
		PASSWORD = pASSWORD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.submitted = submitted;
	}
	public Student(String userName, String pASSWORD, String firstName, String lastName, String dateOfBirth,
			String emailAddress,boolean submitted) {
		super();
		this.userName = userName;
		PASSWORD = pASSWORD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.submitted = submitted;
	}
    
    
    

}
