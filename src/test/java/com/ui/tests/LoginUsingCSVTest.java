package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.listeners.MyRetry;
import com.ui.pages.HomePage;
import com.ui.pojos.UserCredentials;
import com.ui.testDataProvider.LoginProvider;

@Listeners({ com.ui.listeners.MyTestListener.class }) 
public class LoginUsingCSVTest extends BaseTest {

	
	
	@Test(description="Check for the valid user login", retryAnalyzer=MyRetry.class, dataProviderClass=LoginProvider.class,
			dataProvider="getCSVData")
	public void validUserLogintest(UserCredentials u) {
		
		String actualAccountName =new HomePage().clickOnSignInLink()
				.enterloginCredentials(u.getUsername(), u.getPassword()).getAccountName();
	   
		assertEquals(actualAccountName,u.getName());
	}
}
