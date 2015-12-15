package com.starterkit.selenium.books;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import com.starterkit.selenium.books.pages.MainPage;

public class AbstractSeleniumTest {
	protected WebDriver webDriver;
	
	
	@Before
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("init.accept_languages", "en");
		webDriver = new FirefoxDriver(profile);
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public final MainPage openSite() {
		return PageFactory.initElements(webDriver, MainPage.class);
	}
	
	
	@After
	public void tearDown() {
		if(webDriver != null)
			webDriver.quit();
	}
}
