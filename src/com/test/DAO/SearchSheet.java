package com.test.DAO;

import com.test.beans.LoginBeans;
import com.test.beans.SearchBean;

public class SearchSheet {

	public  SearchBean getSearchData(String testId){
		if(testId.equalsIgnoreCase("TC03")){
			return new SearchBean("TC03","T-shirts");
			
		}
		return null;
	}
	
	
}
