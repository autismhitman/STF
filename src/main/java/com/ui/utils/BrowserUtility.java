package com.ui.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ui.constants.WaitStrategy;
import com.ui.drivers.DriverManager;

public class BrowserUtility {
	
	Logger logger = LoggerUtil.getLogger(this.getClass());
	
	protected void click(By locator) {
		logger.info("Clicing on the element for the locator "+ locator);
		WaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, locator).click();
	}
	
	protected void goToWebsite(String url) {
		logger.info("Navigating to the website "+ url);
		DriverManager.getDriver().get(url);
	}
	
	protected void enterText(String value, By locator) {
		logger.info("Entering the string " + value+ " for the locator "+ locator);
		WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator).sendKeys(value);
	}
	
	protected String getText(By locator) {
		logger.info("Getting the text for the element located by "+ locator);
		return WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, locator).getText();
	}

}
