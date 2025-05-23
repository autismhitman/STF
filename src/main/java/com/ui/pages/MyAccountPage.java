package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ui.reports.ExtentLogger;
import com.ui.utils.BrowserUtility;
import com.ui.utils.LoggerUtil;

public class MyAccountPage extends BrowserUtility{
	
	private static final By ACCOUNT_NAME = By.cssSelector("a.account span");
	Logger logger = LoggerUtil.getLogger(this.getClass());
	
	public String getAccountName() {
		logger.info("Fetching the account name of the loggedin user "+ getText(ACCOUNT_NAME));
		ExtentLogger.info("Fetching the account name of the loggedin user "+ getText(ACCOUNT_NAME));
		return getText(ACCOUNT_NAME);
	}

}
