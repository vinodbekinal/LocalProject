package com.test.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class TakeScreenShot {
		public static String filePath="/ExtentReports/screenshot/";
	public static String getScreenCapture(WebDriver driver, String testName){
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file,new File(filePath+testName+".png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return (filePath+testName+".png");
	}
}
