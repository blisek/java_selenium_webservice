package com.starterkit.selenium.books.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends AbstractPage {

	private static final String TABLE_ROWS_EXCEPT_FIRST = "/html/body/div[2]/div/section/table/tbody/tr[position()>1]";
	private static final String BOOK_ROW = "/html/body/div[2]/div/section/table/tbody/tr[%d]";
	private static final String BOOK_TITLE = BOOK_ROW + "/td[1]";
	private static final String EDIT_BOOK_MUSTER = BOOK_ROW + "/td[3]/a[2]";
	private static final String REMOVE_BOOK_MUSTER = BOOK_ROW + "/td[3]/a[3]";

	public BooksPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public int getNumberOfBooks() {
		List<WebElement> elements = webDriver.findElements(By.xpath(TABLE_ROWS_EXCEPT_FIRST));
		return elements.size();
	}
	
	public BooksPage deleteFirstBook() {
		String path = String.format(REMOVE_BOOK_MUSTER, 2);
		webDriver.findElement(By.xpath(path)).click();
		return this;
	}
	
	public EditBookPage editFirstBook() {
		String path = String.format(EDIT_BOOK_MUSTER, 2);
		webDriver.findElement(By.xpath(path)).click();
		return PageFactory.initElements(webDriver, EditBookPage.class);
	}
	
	public String getFirstBookTitle() {
		String path = String.format(BOOK_TITLE, 2);
		return webDriver.findElement(By.xpath(path)).getText();
	}
	
}
