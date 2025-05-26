package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ui.reports.ExtentLogger;
import com.ui.utils.BrowserUtility;
import com.ui.utils.LoggerUtil;

public class MyAccountPage extends BrowserUtility{
	
	private static final By ACCOUNT_NAME = By.cssSelector("a.account span");
	private static final By ADD_ADDRESS = By.xpath("//a[@title='Add my first address']");
    private static final By SEARCH_TEXT_FIELD = By.id("search_query_top");
    private static final By product_Name =By.cssSelector("h5[itemprop='name'] > a.product-name");
	
	Logger logger = LoggerUtil.getLogger(this.getClass());
	
	public String getAccountName() {
		logger.info("Fetching the account name of the loggedin user "+ getText(ACCOUNT_NAME));
		ExtentLogger.info("Fetching the account name of the loggedin user "+ getText(ACCOUNT_NAME));
		return getText(ACCOUNT_NAME);
	}
	
	public AddressPage addAddress() {
		
		click(ADD_ADDRESS);
		return new AddressPage();
	}
	
	 
   public MyAccountPage enterSearchText(String value) {
	   
	   enterText(value,SEARCH_TEXT_FIELD, Keys.ENTER);
	   return this;
   }
   
   
   public int  getCountOfProductList() {
	   
	   return getListOfProductName(product_Name).size();
   }
   
   public boolean isSearchTermPresent(String name) {
	   
	   String[]  pName = name.toLowerCase().split(" ");//Printed Summer Dress
	   List<WebElement> products = getListOfProductName(product_Name);
	   
	   List<String> list =  products.stream().map(x->x.getText()).toList();
	   
	   return list.stream().anyMatch(x->Arrays.stream(pName).anyMatch( x.toLowerCase()::contains));
   }
   
}
