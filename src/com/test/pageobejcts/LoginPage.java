package com.test.pageobejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.DAO.LoginSheet;
//import com.test.DAO.LoginDAO;
import com.test.beans.LoginBeans;
import com.test.core.Core;
import com.test.extentreport.ExtentTestManager;



public class LoginPage{ 
	
	@FindBy(linkText="Sign in")
	private WebElement signin;
	@FindBy(linkText="Vinod B")
	private WebElement username;
   
   WebDriver driver;
   String testId;
   LoginBeans login;
   
   
	
	public LoginPage(WebDriver driver, String testId ){
		this.testId=testId;
		this.driver=driver;
		LoginSheet loginD=new LoginSheet();
		login=loginD.getLoginData(testId);
		System.out.println(login.getTestId());
		System.out.println(login.getUserName());
		PageFactory.initElements(driver, this);
		}
	
	public HomePage doLogin(){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
		
		driver.findElement(By.id("email")).sendKeys(login.getUserName());
		driver.findElement(By.id("passwd")).sendKeys(login.getPwd());
		driver.findElement(By.id("passwd")).sendKeys(Keys.ENTER);
		Assert.assertTrue(username.isDisplayed(),
				"The user is logged in.");
		ExtentTestManager.getTest().log(
				LogStatus.PASS,
				"The user " + login.getUserName()
						+ " logged in sucessfully.");
		return new HomePage(driver, testId);
		
	}
	
public void doLoginandverify(){
		
		signin.click();
		
		driver.findElement(By.id("email")).sendKeys(login.getUserName());
		driver.findElement(By.id("passwd")).sendKeys(login.getPwd());
		driver.findElement(By.id("passwd")).sendKeys(Keys.ENTER);
		Assert.assertTrue(username.isDisplayed(),
				"The user is logged in.");

		ExtentTestManager.getTest().log(
				LogStatus.PASS,
				"The user " + login.getUserName()
						+ " logged in sucessfully.");
		
		
	}


	
	
}
