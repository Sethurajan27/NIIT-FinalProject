package com.niit.entity;

import org.springframework.stereotype.Component;

@Component
public class LoginDetails {
	private String userName;
	private String password;
	public LoginDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public LoginDetails() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
