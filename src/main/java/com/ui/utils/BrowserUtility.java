package com.ui.utils;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	protected void enterText(String value, By locator, Keys key) {
		logger.info("Entering the string " + value+ " for the locator "+ locator);
		WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator).sendKeys(value, key);
	}
	
	protected void clearAndEnterText(String value, By locator) {
		logger.info("Entering the string " + value+ " for the locator "+ locator);
		WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator).clear();
		enterText(value,locator);
	}
	
	protected String getText(By locator) {
		logger.info("Getting the text for the element located by "+ locator);
		return WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, locator).getText();
	}
	
	protected void selectDropdown( String text,By locator) {
		logger.info("Getting the text for the element located by "+ locator);
		WebElement element = DriverManager.getDriver().findElement(locator);
		logger.info("Selecting the dropdown value " + text +" for the element located by "+ locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	protected List<WebElement> getListOfProductName(By locator){
		logger.info("Getting the list of the webelements located by "+ locator);
		return DriverManager.getDriver().findElements(locator);
	}

}
