package com.ui.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ui.utils.ScreenShotUtils;

public class ExtentLogger {

	
	public static void pass(String message) {
		
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void info(String message) {

		ExtentManager.getExtentTest().info(message);
	} 
	
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void failWithScreenshot(String message ) {
		
		 ExtentManager.getExtentTest().fail(message,
				 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.captureScreeshot()).build());
	}
	
	 
}
