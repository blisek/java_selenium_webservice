package com.starterkit.selenium.books.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected final String MESSAGE_FRAME_ID = "flashMessageFrame";
	protected final String FLASH_MESSAGE_INNER_MSG_PATH = "//div[@id = 'flashMessageFrame']/div/span/span";
	protected final WebDriver webDriver;

	public AbstractPage(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}
	
	public boolean hasErrors() {
		return false;
	}
	
	public AbstractPage waitImplicitly(long seconds) {
		webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return this;
	}
	
	public AbstractPage waitUntilFlashMessageAppears() {
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FLASH_MESSAGE_INNER_MSG_PATH)));
		return this;
	}
	
	public boolean isFlashMessagePresent() {
		try {
			return !webDriver.findElement(By.xpath(FLASH_MESSAGE_INNER_MSG_PATH)).getText().isEmpty();
		} catch(NoSuchElementException ex) {
			return false;
		}
	}
	
	public WebElement eraseInputFieldText(WebElement inputField) {
		inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		return inputField;
	}
	
}
