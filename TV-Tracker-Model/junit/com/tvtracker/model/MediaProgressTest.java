package com.tvtracker.model;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaProgressTest {

	private Media testMedia, testMedia2;
	private MediaProgress testMediaProgress;
	private Map<Media, Progress> testMap;
	
	@Before
	public void setup() {
		testMedia = new Media("Forry");
		testMedia2 = new Media("Austin");
		testMap = new HashMap<Media, Progress>();
		testMap.put(testMedia, new Progress(1, 1));
		testMediaProgress = new MediaProgress(testMap);
	}
	
	@Test
	public void testGetProgress() {
		assertEquals(1, testMediaProgress.getProgress(testMedia).getEpisodesSeen());
		assertEquals(1, testMediaProgress.getProgress(testMedia).getCurrentSeason());
	}
	
	@Test
	public void testAddMedia() {
		testMediaProgress.addMedia(testMedia2, new Progress(2, 1));
		assertEquals(2, testMediaProgress.getProgress(testMedia2).getEpisodesSeen());
		assertEquals(1, testMediaProgress.getProgress(testMedia2).getCurrentSeason());
	}
	
}
