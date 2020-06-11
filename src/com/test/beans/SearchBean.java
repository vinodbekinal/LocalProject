package com.test.beans;

public class SearchBean {
	private String testId;
	private String searchProduct;

	public SearchBean(String testId,String searchProduct) {
		super();
		this.searchProduct = searchProduct;
		this.testId = testId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getSearchProduct() {
		return searchProduct;
	}

	public void setSearchProduct(String searchProduct) {
		this.searchProduct = searchProduct;
	}
	
}
