package com.application.bean;

public class UserObject {
private String fullName,userName,password;
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		this.fullName=fullName;
		System.out.println("user name comes "+fullName);

	}

	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName=userName;
		System.out.println("user name comes "+userName);
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
		System.out.println("user name comes "+password);

	}

	public String getFullName() {
		return fullName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
