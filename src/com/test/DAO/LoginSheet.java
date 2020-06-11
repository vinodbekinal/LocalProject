package com.test.DAO;

import com.test.beans.LoginBeans;


public class LoginSheet {

	public  LoginBeans getLoginData(String testId){
		if(testId.equalsIgnoreCase("TC01")){
			return new LoginBeans("TC01","vinod.bekinal@xyz.com","Vinod123");
			
		}
		if(testId.equalsIgnoreCase("TC02")){
			return new LoginBeans("TC02","vinod.bekinal@xyz.com","23213");
			
		}
		if(testId.equalsIgnoreCase("TC03")){
			return new LoginBeans("TC03","vinod.bekinal@xyz.com","Vinod123");
			
		}
		return null;
	}
}
