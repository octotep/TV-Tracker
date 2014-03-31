package com.tvtracker.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaListTest {
	private Media testMedia;
	private MediaList testMediaList;
	
	@Before
	public void setup() {
		testMedia = new Media("Forry");
		testMediaList = new MediaList();
		testMediaList.addMedia(testMedia);
	}
	
	@Test
	public void testGetMediaList() {
		assertEquals(testMediaList, testMediaList.getMediaList());
	}
}
