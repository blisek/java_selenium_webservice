package com.starterkit.selenium.books;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.starterkit.selenium.books.pages.BooksPage;

public class BookSearchTest extends AbstractSeleniumTest {
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
	public void shouldListAllBooksWithRequestedPrefix() {
		final String prefix = "p";
		final List<String> correctBooks = 
				booksPage.getAllBooksTitles()
				.stream()
				.filter(bookTitle -> bookTitle.toLowerCase().startsWith(prefix))
				.collect(Collectors.toList());
		List<String> foundBooks = booksPage
				.setTitlePrefixField(prefix)
				.clickSearchBookButton()
				.waitImplicitly(2)
				.getAllBooksTitles();
		
		assertEquals(correctBooks.size(), foundBooks.size());
		assertTrue(foundBooks.containsAll(correctBooks));
	}
	
	@Test
	public void shouldFindFirstBook() {
		String firstBookTitle = booksPage.getFirstBookTitle();
		List<String> booksTitlesLikeFirstBookTitle = booksPage
				.setTitlePrefixField(firstBookTitle)
				.clickSearchBookButton()
				.waitImplicitly(2)
				.getAllBooksTitles();
		
		assertTrue(booksTitlesLikeFirstBookTitle.size() >= 1);
		assertTrue(booksTitlesLikeFirstBookTitle.contains(firstBookTitle));
	}
}
