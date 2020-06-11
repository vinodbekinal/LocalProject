package com.test.pageobejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.DAO.LoginSheet;
import com.test.DAO.SearchSheet;
import com.test.beans.SearchBean;
import com.test.extentreport.ExtentTestManager;

public class SearchPage {
	
	
WebDriver driver;
String testId;
SearchBean searchbean;
	public SearchPage(WebDriver driver, String testId){
		this.driver=driver;
		this.testId=testId;
		SearchSheet searchD=new SearchSheet();
		searchbean=searchD.getSearchData(testId);
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(){
		
		driver.findElement(By.id("search_query_top")).sendKeys(searchbean.getSearchProduct());
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		WebElement searchresult=driver.findElement(By.xpath("//span[contains(text(),'result has been found.')]"));
		Assert.assertTrue(searchresult.isDisplayed(), "Search results displayed");
		ExtentTestManager.getTest().log(
				LogStatus.PASS,
				 searchbean.getSearchProduct()
						+ " product search results displayed");
		
	}
	
	public void searchByMenu(){
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"))).build().perform();
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a/parent::li//descendant::a[text()='Casual Dresses']")).click();
		WebElement searchresult=driver.findElement(By.xpath("//*[@id='center_column']/div[2]/div[2]/div[2]"));
		Assert.assertTrue(searchresult.isDisplayed(), "Search result displayed sucessfully");
		ExtentTestManager.getTest().log(
				LogStatus.PASS,
				 " Search results displayed sucessfuly");
	}

	
	
	
}
