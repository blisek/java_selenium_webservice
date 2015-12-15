package com.starterkit.selenium.books.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected final String MESSAGE_FRAME_ID = "flashMessageFrame";
	protected final WebDriver webDriver;

	public AbstractPage(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}
	
	public boolean hasErrors() {
//		try {
//			WebElement element = webDriver.findElement(By.id(MESSAGE_FRAME_ID));
//			return !element.getText().isEmpty();
//		} catch(NoSuchElementException e) {
//			return false;
//		}
		return false;
	}
}
