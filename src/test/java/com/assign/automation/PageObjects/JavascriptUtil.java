package com.assign.automation.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {

	WebDriver driver;

	public JavascriptUtil(WebDriver driver) {
		this.driver = driver;
	}

	// This method will Scroll the page until the element is not visible on page
	public void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
