package com.starterkit.selenium.books;


import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.starterkit.selenium.books.pages.BooksPage;
import com.starterkit.selenium.books.pages.EditBookPage;

public class BookEditTest extends AbstractSeleniumTest {
	private BooksPage booksPage;

	@Before
	public void setUp() {
		super.setUp();
		booksPage = openSite().clickBooksPage();
	}

	@After
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void shouldEditBookTitle() {
		String newTitle = Integer.toString(new Random().nextInt());
		booksPage.editFirstBook().eraseBookTitle().setBookTitle(newTitle).saveBook();
		String firstBookTitle = 
				booksPage.waitUntilFlashMessageAppears().getFirstBookTitle();
		
		assertEquals(newTitle, firstBookTitle);
	}
	
	@Test
	public void shouldEditBookOKButtonBeDisabled() {
		EditBookPage editPage = booksPage.editFirstBook().eraseBookTitle();
		assertFalse(editPage.isSaveButtonEnabled());
	}
	
	@Test
	public void shouldCanceledEditionNotBeComitted() {
		String oldTitle = booksPage.getFirstBookTitle();
		booksPage.editFirstBook().setBookTitle("new title").discardChanges();
		String newTitle = booksPage.getFirstBookTitle();
		
		assertEquals(oldTitle, newTitle);
	}
}
