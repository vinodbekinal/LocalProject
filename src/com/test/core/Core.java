package com.test.core;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.pfsautomation.core.ITestContext;
import com.relevantcodes.extentreports.LogStatus;
import com.test.driverpackage.DriverFactory;
import com.test.extentreport.ExtentManager;
import com.test.extentreport.ExtentTestManager;
import com.test.utility.EnvironmentProperties;
import com.test.utility.TakeScreenShot;

public class Core implements ITest {
	protected WebDriver driver;
	protected String testId;
	protected String browser;
	EnvironmentProperties environment;
	String testCaseName;
	
	@BeforeSuite
	public void setup(){
		environment.getInstance();			
	}
	
	@BeforeTest
	@Parameters({"browser","testId"})
	public void launchLogin(String browser, String testId,org.testng.ITestContext  testContext){
		this.testId=testId;
		ExtentTestManager.startTest(testId+": "+testContext.getName());
		testCaseName = testContext.getName();
		driver=DriverFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(environment.TEST_AUTOMATION_URL);
	}
	
	@AfterMethod
	public void afterTest(ITestResult result){
		if(result.getStatus() ==ITestResult.FAILURE){
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable()
			+ExtentTestManager.getTest().addScreenCapture(TakeScreenShot.getScreenCapture(driver,result.getTestName())));
		}
		else if(result.getStatus() ==ITestResult.SKIP){
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " +result.getThrowable());
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		}
		
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());        
        ExtentManager.getReporter().flush();
	}
	
	@AfterTest
	public void afterTestActivity(){
		driver.close();
		driver.quit();
		driver=null;
	}


	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return  testCaseName;
	}
	
	
	
}