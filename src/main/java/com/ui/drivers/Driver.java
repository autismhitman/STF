package com.ui.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

 
public class Driver {
		
	 public static void initDriver(String browserName, boolean isRemote, String testName) {
		 
		if(Objects.isNull(DriverManager.getDriver())){
			
			WebDriver driver = DriverFactory.getBrowser(browserName, isRemote, testName);
			DriverManager.setDriver(driver);
		} 
		
	}
	
     public static void closeDriver() {
		
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
			
		}
	}

}
