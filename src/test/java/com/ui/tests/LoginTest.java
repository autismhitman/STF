package com.ui.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

@Listeners({ com.ui.listeners.MyTestListener.class, com.ui.listeners.MyTransformer.class ,
	          com.ui.listeners.MyMethodInterceptor.class }) 
public class LoginTest extends BaseTest {

	
	
	@Test(description="Check for the valid user login" )
	public void validUserLogintest(HashMap<String, String> hmap) {
		
		String actualAccountName =new HomePage().clickOnSignInLink()
				.enterloginCredentials(hmap.get("username"), hmap.get("password")).getAccountName();
	   
		assertEquals(actualAccountName,hmap.get("accountName"));
	}
}
