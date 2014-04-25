package com.tvtracker.model;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaListProgressTest {
	
	private Media testMedia, testMedia2;
	private MediaListProgress testMediaListProgress;
	private MediaList testMediaList;
	private MediaProgress testMediaProgress;
	private Map<Media, Progress> testMap;
	private Integer integer;
	
	@Before
	public void setup() {
		testMedia = new Media("Forry");
		testMedia2 = new Media("Austin");
		testMap = new HashMap<Media, Progress>();
		testMap.put(testMedia, new Progress(1, 1, 1));
		testMediaList = new MediaList();
		testMediaProgress = new MediaProgress(testMap);
		testMediaListProgress = new MediaListProgress(testMediaList, testMediaProgress);
		
	}
	
	@Test
	public void testCurrentProgress() {
		integer = 1;
		assertEquals(integer, testMediaProgress.getProgress(testMedia).getEpisodesSeen());
		assertEquals(integer, testMediaProgress.getProgress(testMedia).getCurrentSeason());
	}
	
	@Test
	public void testAddMedia() {
		testMediaListProgress.addMedia(testMedia2, 1, 1, 1);
		integer = 1;
		assertEquals(integer, testMediaProgress.getProgress(testMedia2).getEpisodesSeen());
		integer = 1;
		assertEquals(integer, testMediaProgress.getProgress(testMedia2).getCurrentSeason());
		assertEquals(integer, testMediaProgress.getProgress(testMedia).getEpisodesSeen());
		assertEquals(integer, testMediaProgress.getProgress(testMedia).getCurrentSeason());
	}
}
