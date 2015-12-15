package com.starterkit.selenium.books.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private static final String ADDRESS = "http://localhost:9000/";
	
	@FindBy(linkText = "Books dialog")
	private WebElement booksPage;
	
	@FindBy(linkText = "Authors")
	private WebElement authorsPage;

	public MainPage(WebDriver webDriver) {
		super(webDriver);
		webDriver.get(ADDRESS);
	}
	
	public BooksPage clickBooksPage() {
		booksPage.click();
		return PageFactory.initElements(webDriver, BooksPage.class);
	}

	public AuthorsPage clickAuthorsPage() {
		authorsPage.click();
		return PageFactory.initElements(webDriver, AuthorsPage.class);
	}
}
