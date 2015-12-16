package com.starterkit.selenium.books.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorsPage extends AbstractPage {

	private WebElement filterInput;
	
	public AuthorsPage(WebDriver webDriver) {
		super(webDriver);
	}

	public List<String> getAuthorsLastNames() {
		return webDriver.findElements(By.xpath("//table/tr[position() > 1]/td[3]"))
			.stream()
			.map(WebElement::getText)
			.collect(Collectors.toList());
	}
	
	public AuthorsPage eraseFilterInputText() {
		eraseInputFieldText(filterInput);
		return this;
	}
	
	public AuthorsPage setFilterInputText(String text) {
		filterInput.sendKeys(text);
		return this;
	}

}
