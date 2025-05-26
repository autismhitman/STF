package com.ui.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.MyRetry;
import com.ui.pages.HomePage;
import com.ui.testDataProvider.LoginProvider;


@Listeners({ com.ui.listeners.MyTestListener.class }) 

public class SearchProductTest extends BaseTest{
	
	
	@Test(description="Check for the count of search term result", dataProvider="getData")
	public void searchTermResultCountTest(HashMap<String, String> hmap) {
		
		int count  = new HomePage().clickOnSignInLink()
				.enterloginCredentials(hmap.get("username"), hmap.get("password")).enterSearchText("Printed Summer Dress")
				.getCountOfProductList();
		
		assertEquals(count,3);
	   

	}
	
	@Test(description="Check for the search term is presence",  dataProvider="getData")
	public void searchTermResultTest(HashMap<String, String> hmap) {
		
		boolean result =   new HomePage().clickOnSignInLink()
				.enterloginCredentials(hmap.get("username"), hmap.get("password")).enterSearchText("Printed Summer Dress")
				.isSearchTermPresent("Printed Summer Dress");
		
		 assertEquals(result,true)	   ;

	}
	

}
