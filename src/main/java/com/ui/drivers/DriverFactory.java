package com.ui.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 

public class DriverFactory {
	
	
	public static WebDriver getBrowser(String browserName, boolean isRemote, String testName) {
		
		WebDriver driver= null;
		
		if(isRemote) {
			
			driver= LambdaTestCloud.setup(browserName, testName);
		}
		
		else {
			
				if(browserName.equalsIgnoreCase("chrome")) {
					
					driver= new ChromeDriver();
					driver.manage().window().maximize();
				}
				else if(browserName.equalsIgnoreCase("edge")) {
					
					driver= new EdgeDriver();
					driver.manage().window().maximize();
				}
				else if(browserName.equalsIgnoreCase("ff")) {
					
					driver= new FirefoxDriver();
					driver.manage().window().maximize();
				}
		}		
		
		return driver;
	}

}
