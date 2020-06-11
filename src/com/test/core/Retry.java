package com.test.core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
 int count =0;
 int retrycount=2;
	@Override
	public boolean retry(ITestResult result) {
		if(count <retrycount){
			System.out.println("Retrying test with"+result.getTestName()+
					"with status"+getresult(result.getStatus()));
			count++;
			return true;
		}
		return false;
	}
	public static String  getresult(int value){
		String result=null;
		if(value == 1){
			result= "SUCCESS";
		}
		if(value == 2){
			result= "FAILURE";
		}
		if(value == 3){
			result= "SKIP";
		}
		return result;
	}

	
}
