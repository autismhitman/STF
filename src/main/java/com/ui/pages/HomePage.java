package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ui.constants.Environment;
import com.ui.reports.ExtentLogger;
import com.ui.utils.BrowserUtility;
import com.ui.utils.LoggerUtil;
import com.ui.utils.PropertyUtils;

public class HomePage extends BrowserUtility{
	
	private static final By SIGN_IN_LINK = By.cssSelector("a.login");
	private static final By EMAIL_FIELD = By.id("email");
	private static final By PASSWORD_FIELD = By.id("passwd");
	private static final By SIGNIN_BTN = By.cssSelector("button#SubmitLogin");
	Logger logger = LoggerUtil.getLogger(this.getClass());
	
	public HomePage clickOnSignInLink() {
		logger.info("Fetching the url link");
		ExtentLogger.info("Fetching the url link");
		goToWebsite(PropertyUtils.readValue(Environment.URL.toString()));
		logger.info("clicking on the signinlink");
		ExtentLogger.info("clicking on the signinlink");
		click(SIGN_IN_LINK);
		return this;
		
	}
	

	public MyAccountPage enterloginCredentials(String username, String password) {
		logger.info("Entering the username "+ username);
		ExtentLogger.info("Entering the username "+ username);
		enterText(username,EMAIL_FIELD );
		logger.info("Entering the password "+ password);
		ExtentLogger.info("Entering the password "+ password);
		enterText(password,PASSWORD_FIELD);
		logger.info("clicking on the signinbtn");
		ExtentLogger.info("clicking on the signinbtn");
		click(SIGNIN_BTN);
		logger.info("login successful");
		ExtentLogger.info("login successful");
		return new MyAccountPage();
		
	}

}
