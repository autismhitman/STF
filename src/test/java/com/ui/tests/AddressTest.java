package com.ui.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.Address;
import com.ui.utils.FakerUtil;

@Listeners({ com.ui.listeners.MyTestListener.class }) 
public class AddressTest extends BaseTest{

	MyAccountPage myAccountPage ;
	Address address = FakerUtil.getAddressData() ;
	
	 
	
	@Test(description="user is able to add new address")
	public void addNewAddressTest() {
		
	   String text= new HomePage().clickOnSignInLink()
		.enterloginCredentials("rejiva4640@magpit.com", "password")
		.addAddress().enterAndSaveAddressDetails(address);
	
		 assertEquals(text,"MY ADD");
		
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(20));
	}
	
	
	
	
	
	
	
	
	
	
	
}
