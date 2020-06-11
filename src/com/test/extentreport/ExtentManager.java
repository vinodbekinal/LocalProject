package com.test.extentreport;


import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	static  ExtentReports extent;
	public static final String filepath="ExtentReports/"+com.test.utility.EnvironmentProperties.EXECUTION_TIMESTAMP+"/TestProject.html";
	public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filepath, false);
            extent.loadConfig(new File("src/com/test/configurations/extent-config.xml"));
        }
        
        return extent;
    }
}

