package com.test.flow;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.core.Core;
import com.test.pageobejcts.LoginPage;
import com.test.pageobejcts.SearchPage;

public class SearchFlow extends Core{

	@Test
	public void searchPagep(){
		LoginPage loginp=new LoginPage(driver, testId);
		loginp.doLogin().goToSearchPage().searchProduct();
		
	}
	
	@Test(enabled=false)
	public void searchbyMenu() throws InterruptedException{
		SearchPage searchp=new SearchPage(driver, testId);
		searchp.searchByMenu();
	}
}


