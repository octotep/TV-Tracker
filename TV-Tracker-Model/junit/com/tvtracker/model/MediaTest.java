package com.tvtracker.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaTest {
	private Media lost;
	private Media flamenco;
	
	@Before
	public void setUp() throws Exception {
		lost = new Media("Lost");
		flamenco = new Media("Samurai Flamenco");
	}

	@Test
	public void testGetName() {
		assertEquals("Samurai Flamenco", flamenco.getName());
		assertEquals("Lost", lost.getName());
	}

	@Test
	public void testSetName() {
		flamenco.setName("Kill la Kill");
		assertEquals("Kill la Kill", flamenco.getName());
	}
	
}
