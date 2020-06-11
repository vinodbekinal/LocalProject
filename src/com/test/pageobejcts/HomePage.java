package com.test.pageobejcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.extentreport.ExtentTestManager;

public class HomePage {
	@FindBy(linkText="Vinod B")
	private WebElement username;
	
	WebDriver driver;
	String testId;
	
	public HomePage(WebDriver driver,String testId){
		this.testId=testId;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public SearchPage goToSearchPage(){
		try {
			Thread.sleep(2000);
			Assert.assertEquals(username.getText(), "Vinod B");
			ExtentTestManager.getTest().log(
					LogStatus.PASS,
					"The user " + username.getText()
							+ " is present in HomePage.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new SearchPage(driver, testId);

		
	}

	
}

