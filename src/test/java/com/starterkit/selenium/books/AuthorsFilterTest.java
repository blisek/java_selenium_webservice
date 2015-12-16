package com.starterkit.selenium.books;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.starterkit.selenium.books.pages.AuthorsPage;

public class AuthorsFilterTest extends AbstractSeleniumTest {
	private AuthorsPage authorsPage;
	
	@Before
	public void setUp() {
		super.setUp();
		authorsPage = openSite().clickAuthorsPage();
	}

	@After
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void shouldFilterAllAuthors() {
		final String prettyRandomString = "jeofaewg[aok,waop,p[wd,msap[fks,mafpe[ja[of";
		authorsPage.setFilterInputText(prettyRandomString);
		List<String> lastNames = authorsPage.getAuthorsLastNames();
		assertTrue(lastNames.isEmpty());
	}
	
	@Test
	public void shouldFilterToSpecifiedAuthors() {
		final String lastNameFragment = "owa";
		List<String> correctLastNames = authorsPage.getAuthorsLastNames()
				.stream()
				.filter(name -> name.contains(lastNameFragment))
				.collect(Collectors.toList());
		
		List<String> filteredAuthors = authorsPage.eraseFilterInputText()
				.setFilterInputText(lastNameFragment).getAuthorsLastNames();
		assertTrue(filteredAuthors.containsAll(correctLastNames));
	}

}
