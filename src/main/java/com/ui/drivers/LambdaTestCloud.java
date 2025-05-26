package com.ui.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

 public class LambdaTestCloud {

	   static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
	   static final String USERNAME= "restpostman1";
	   static final String ACCOUNTKEY ="LT_KrjPPM732aEwK24eVMvVsvp2tmFO5RHnDwMz2vs3NI22Jzb";
	   
	   public static WebDriver setup(String browserName, String testName)  {

	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browserName);
	        capabilities.setCapability("browserVersion", "127");
	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user", USERNAME);
	        ltOptions.put("accessKey", ACCOUNTKEY);
	        ltOptions.put("build", "Demo Project");
	        ltOptions.put("name", testName);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "4.23.0");
	        capabilities.setCapability("LT:Options", ltOptions);

	        WebDriver driver =null;
			try {
				driver = new RemoteWebDriver(new URL(HUBURL), capabilities);
			} catch (MalformedURLException e) {
				 
				e.printStackTrace();
			}
	        System.out.println(driver);
	        return driver;
	    }
}
