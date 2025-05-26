package com.ui.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports extentReports;
	static ExtentSparkReporter sparkReporter;
	
	public static void initReports() {
		if(Objects.isNull(extentReports)){
			extentReports = new ExtentReports();			
			sparkReporter= new ExtentSparkReporter("./reports/index.html");
			sparkReporter.config().setDocumentTitle("Demo Automation Framework Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setReportName("Test Report Execution");
			extentReports.attachReporter(sparkReporter);
		}
 	
	}
	
	
	public static void flushReport() {
		if(Objects.nonNull(extentReports)) {
			extentReports.flush();
			
		}
		ExtentManager.unload();
	}
	
	public static void createTest(String testName) {
		  ExtentManager.setExtentTest(extentReports.createTest(testName));
	}

}
