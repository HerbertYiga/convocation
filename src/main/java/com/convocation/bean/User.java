package com.convocation.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	
	
	@NotEmpty(message="please insert password")
	private String password;
	@NotEmpty(message="please insert user name")
	
	
	private String username;
	
	
	private String authority;
	
	private int phoneNumber;
	
	
	private String enable;
	
	private int userId;
	
	private int userRoleId;
	
	private String password2;
	
	
	
	
	//password
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//user name
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//authority
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	//phone number
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//enable
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	//password two
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	

}
