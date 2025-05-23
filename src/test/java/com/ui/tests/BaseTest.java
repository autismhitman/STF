package com.ui.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.constants.Browser;
import com.ui.drivers.Driver;

public class BaseTest {
	
	@Parameters({"browserName","isRemote"})
	@BeforeMethod
	public void setup(@Optional("edge") String browserName,
			          @Optional("false") boolean isRemote, 
			           Method m) {
		
		Driver.initDriver(browserName, isRemote, m.getName());
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		Driver.closeDriver();
	}
     
}
