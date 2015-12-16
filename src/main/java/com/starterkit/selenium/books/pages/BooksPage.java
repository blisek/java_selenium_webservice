package com.starterkit.selenium.books.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends AbstractPage {

	private static final String TABLE_ROWS_EXCEPT_FIRST = "/html/body/div[2]/div/section/table/tbody/tr[position()>1]";
	private static final String BOOK_ROW = "/html/body/div[2]/div/section/table/tbody/tr";
	private static final String BOOK_TITLE = BOOK_ROW + "/td[1]";
	private static final String SPECIFIED_BOOK_ROW = BOOK_ROW + "[%d]";
	private static final String SPECIFIED_BOOK_TITLE = SPECIFIED_BOOK_ROW + "/td[1]";
	private static final String SPECIFIED_EDIT_BOOK_MUSTER = SPECIFIED_BOOK_ROW + "/td[3]/a[2]";
	private static final String SPECIFIED_REMOVE_BOOK_MUSTER = SPECIFIED_BOOK_ROW + "/td[3]/a[3]";

	private WebElement searchBookInput;
	private WebElement searchBookButton;
	private WebElement addBookButton;
	
	public BooksPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public int getNumberOfBooks() {
		List<WebElement> elements = webDriver.findElements(By.xpath(TABLE_ROWS_EXCEPT_FIRST));
		return elements.size();
	}
	
	public BooksPage deleteFirstBook() {
		String path = String.format(SPECIFIED_REMOVE_BOOK_MUSTER, 2);
		webDriver.findElement(By.xpath(path)).click();
		return this;
	}
	
	public EditBookPage editFirstBook() {
		String path = String.format(SPECIFIED_EDIT_BOOK_MUSTER, 2);
		webDriver.findElement(By.xpath(path)).click();
		return PageFactory.initElements(webDriver, EditBookPage.class);
	}
	
	public String getFirstBookTitle() {
		String path = String.format(SPECIFIED_BOOK_TITLE, 2);
		return webDriver.findElement(By.xpath(path)).getText();
	}
	
	public List<String> getAllBooksTitles() {
		return webDriver.findElements(By.xpath(BOOK_TITLE))
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}
	
	public BooksPage setTitlePrefixField(String text) {
		eraseInputFieldText(searchBookInput).sendKeys(text);
		return this;
	}
	
	public BooksPage clickSearchBookButton() {
		searchBookButton.click();
		return this;
	}
	
	public AddBookPage clickAddBookButton() {
		addBookButton.click();
		return PageFactory.initElements(webDriver, AddBookPage.class);
	}

	@Override
	public BooksPage waitImplicitly(long seconds) {
		super.waitImplicitly(seconds);
		return this;
	}

	@Override
	public BooksPage waitUntilFlashMessageAppears() {
		super.waitUntilFlashMessageAppears();
		return this;
	}
	
	
}
