package com.starterkit.selenium.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.starterkit.selenium.books.pages.AddBookPage;
import com.starterkit.selenium.books.pages.BooksPage;

public class AddBookTest extends AbstractSeleniumTest {
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
	public void shouldAddNewBook() {
		final String newTitle = "Book no." + Integer.toString(new Random().nextInt());
		final String author = "John Newman";
		int booksCountBefore = booksPage.getNumberOfBooks();
		booksPage.clickAddBookButton().setBookTitle(newTitle).addAuthor(author).clickAddBook();
		int booksCountAfter = booksPage.waitUntilFlashMessageAppears().getNumberOfBooks();
		
		assertEquals(booksCountBefore+1, booksCountAfter);
	}
	
	@Test
	public void shouldAuthorInputFieldHasError() {
		assertTrue(booksPage.clickAddBookButton()
				.eraseAuthorInputField()
				.clickAddAuthorButton()
				.hasAuthorInputFieldAnError());
	}
	
	@Test
	public void shouldAddAndRemoveAuthorFromAuthorsList() {
		AddBookPage addBookPage = booksPage.clickAddBookButton().addAuthor("Some author");
		assertFalse(addBookPage.isAuthorListEmpty());
		addBookPage.removeFirstAuthor();
		assertTrue(addBookPage.isAuthorListEmpty());
	}
}
