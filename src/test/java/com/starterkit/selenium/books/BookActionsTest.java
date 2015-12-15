package com.starterkit.selenium.books;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.starterkit.selenium.books.pages.BooksPage;

public class BookActionsTest extends AbstractSeleniumTest {
	
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
	public void shouldRemoveBook() {
		int booksCountBefore = booksPage.getNumberOfBooks();
		int booksCountAfter = booksPage.deleteFirstBook().getNumberOfBooks();
		
		assertFalse(booksPage.hasErrors());
		assertEquals(booksCountBefore-1, booksCountAfter);
	}

}
