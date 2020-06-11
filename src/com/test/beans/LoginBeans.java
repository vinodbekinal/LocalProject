package com.test.beans;

public class LoginBeans {

	private String userName;
	private String pwd;
	private String testId;
	
	
public LoginBeans(String testId,String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
		this.testId=testId;
	}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPwd() {
	return pwd;
}


public void setPwd(String pwd) {
	this.pwd = pwd;
}


public String getTestId() {
	return testId;
}


public void setTestId(String testId) {
	this.testId = testId;
}


	
}
