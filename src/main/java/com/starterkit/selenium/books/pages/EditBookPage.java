package com.starterkit.selenium.books.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditBookPage extends AbstractPage {
	
	private WebElement saveButton;
	private WebElement closeButton;
	private WebElement bookTitle;

	public EditBookPage(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isSaveButtonEnabled() {
		return saveButton.isEnabled();
	}
	
	public EditBookPage setBookTitle(String title) {
		bookTitle.sendKeys(title);
		return this;
	}
	
	public EditBookPage eraseBookTitle() {
		eraseInputFieldText(bookTitle);
		return this;
	}
	
	public void saveBook() {
		saveButton.click();
	}
	
	public void discardChanges() {
		closeButton.click();
	}
}
