package com.ui.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.ui.listeners.MyRetry;
import com.ui.pages.HomePage;
import com.ui.testDataProvider.LoginProvider;

public class LoginTest extends BaseTest {

	
	
	@Test(description="Check for the valid user login", retryAnalyzer=MyRetry.class,
			dataProviderClass=LoginProvider.class, dataProvider="getData")
	public void validUserLogintest(HashMap<String, String> hmap) {
		
		String actualAccountName =new HomePage().clickOnSignInLink()
				.enterloginCredentials(hmap.get("username"), hmap.get("password")).getAccountName();
	   
		assertEquals(actualAccountName,hmap.get("accountName"));
	}
}
