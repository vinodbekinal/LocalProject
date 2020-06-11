package com.test.driverpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/com/test/drivers/chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "");
			return new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("geco")){
			System.setProperty("webdriver.geckodriver.driver", "");
			return new FirefoxDriver();
		}
		else{
		return null;
		}
	}
}
