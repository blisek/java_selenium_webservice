package com.starterkit.selenium.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBookPage extends AbstractPage {
	private static final String ADD_AUTHOR_DIV_ERROR = 
			"/html/body/div[4]/div/div/div/form/div[2]/div[3]";
	
	@FindBy(id = "author")
	private WebElement addAuthorInputField;
	private WebElement addAuthorButton;
	private WebElement addBookBtn;
	private WebElement closeDialogButton;
	private WebElement bookTitle;
	
	public AddBookPage(WebDriver webDriver) {
		super(webDriver);
	}

	public AddBookPage setBookTitle(String title) {
		bookTitle.sendKeys(title);
		return this;
	}
	
	public AddBookPage addAuthor(String name) {
		addAuthorInputField.sendKeys(name);
		addAuthorButton.click();
		return this;
	}
	
	public AddBookPage removeFirstAuthor() {
		webDriver.findElements(By.xpath("//ul[@id = 'bookAuthorsList']/li/a")).get(0)
			.click();
		return this;
	}

	public AddBookPage eraseAuthorInputField() {
		eraseInputFieldText(addAuthorInputField);
		return this;
	}
	
	public AddBookPage eraseBookTitleField() {
		eraseInputFieldText(bookTitle);
		return this;
	}
	
	public AddBookPage clickAddAuthorButton() {
		addAuthorButton.click();
		return this;
	}
	
	@Override
	public AddBookPage waitImplicitly(long seconds) {
		super.waitImplicitly(seconds);
		return this;
	}

	public void clickAddBook() {
		addBookBtn.click();
	}
	
	public void closeDialog() {
		closeDialogButton.click();
	}
	
	public boolean isAddButtonEnabled() {
		return addBookBtn.isEnabled();
	}
	
	public boolean isAuthorListEmpty() {
		try {
			webDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/form/div[2]/div[2]/span"));
			return true;
		} catch(NoSuchElementException ex) {
			return false;
		}
	}
	
	public boolean isAuthorInputFieldEmpty() {
		return addAuthorInputField.getText().isEmpty();
	}
	
	public boolean isBookTitleFieldEmpty() {
		return bookTitle.getText().isEmpty();
	}
	
	public boolean hasAuthorInputFieldAnError() {
		return webDriver.findElement(By.xpath(ADD_AUTHOR_DIV_ERROR))
				.getAttribute("class").contains("has-error");
	}
}
