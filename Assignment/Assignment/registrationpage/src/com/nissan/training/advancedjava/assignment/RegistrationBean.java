package com.nissan.training.advancedjava.assignment;
/* POJO class for registration bean */

public class RegistrationBean {
	private String fname;
	private String lname;
	private String email;
	private String mobile;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/* insert user data to database */
	public boolean save() {
		RegistrationServices registrationServices = new RegistrationServices();
		if(registrationServices.insertUser(fname, lname, email, mobile)) {
			return true;
		}
		else {
			return false; 
		}
	}

}
