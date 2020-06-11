package com.test.flow;

import org.testng.annotations.Test;

import com.test.core.Core;
import com.test.pageobejcts.LoginPage;

public class LoginNegativeFlow extends Core{
	
	@Test
	public void LoginApp(){
	LoginPage login=new LoginPage(driver, testId);
	login.doLoginandverify();
	}
}
