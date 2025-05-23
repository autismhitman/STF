package com.ui.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ui.drivers.DriverManager;

public class ScreenShotUtils {
	
	public static String captureScreeshot() {
		
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
 
}
