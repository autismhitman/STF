package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ui.reports.ExtentLogger;
import com.ui.reports.ExtentReport;
import com.ui.utils.LoggerUtil;

public class MyTestListener implements ITestListener, ISuiteListener {
   
	Logger logger = LoggerUtil.getLogger(this.getClass());
	
	
	public void onStart(ISuite suite) {
       logger.info("Starting the testSuite execution"+ suite );
       ExtentReport.initReports();
	}

	public void onFinish(ISuite suite) {
		
		 logger.info("Completed the testSuite execution "+ suite );
		 ExtentReport.flushReport();
	}

	public void onTestStart(ITestResult result) {
		
		 logger.info("Starting the testCase "+ result.getMethod().getMethodName());
		 ExtentReport.createTest((result.getMethod().getDescription()));

	}

	public void onTestSuccess(ITestResult result) {
		
		 logger.info("Test Case: " + result.getMethod().getMethodName() + " is passed");
		 ExtentLogger.pass(result.getMethod().getMethodName()+ "is Passed");
	}

	public void onTestFailure(ITestResult result) {

		logger.info("Test Case: " + result.getMethod().getMethodName() + " is failed");
		ExtentLogger.failWithScreenshot(result.getMethod().getMethodName()+ "is Failed");
		ExtentLogger.fail(result.getThrowable().toString());
		//ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
	
	}

	public void onTestSkipped(ITestResult result) {
		
		logger.info("Test Case: " + result.getMethod().getMethodName() + " is skipped");
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}

}
