package com.ui.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.constants.WaitStrategy;
import com.ui.drivers.DriverManager;

public class WaitFactory {

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {

		WebElement element = null;

		if (waitStrategy == WaitStrategy.CLICKABLE) {

			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.elementToBeClickable(locator));

		}
		if (waitStrategy == WaitStrategy.VISIBLE) {

			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));

		}
		if (waitStrategy == WaitStrategy.PRESENCE) {

			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
					.until(ExpectedConditions.presenceOfElementLocated(locator));

		}
		if (waitStrategy == WaitStrategy.NONE) {

			element =  DriverManager.getDriver().findElement(locator);

		}

		return element;
	}

}
