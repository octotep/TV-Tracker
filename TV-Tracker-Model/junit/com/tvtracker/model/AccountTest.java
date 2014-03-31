package com.tvtracker.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class AccountTest {
	private Account austin;
	private MediaListProgress testProgress;
	
	@Before
	public void setup() {
		austin = new Account();
		austin.setMediaListProgress(testProgress);
	}
	
	@Test
	public void testGetMediaListProgress() {
		assertEquals(testProgress, austin.getMediaListProgress());
	}
}
