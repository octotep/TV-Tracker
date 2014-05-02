package com.tvtracker.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

/*
 * constructor
 */
public class MediaProgress implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private HashMap<Media, Progress> mediaMap;

	public MediaProgress() {

	}

	/*
	 * initializes the mediaMap
	 */
	public MediaProgress(int id, Map<Media, Progress> mediaMap) {
		this.id = id;
		this.mediaMap = new HashMap<Media, Progress>(mediaMap);
	}

	/*
	 * add media and progress to the mediaMap
	 */
	public void addMedia(Media media, Progress progress) {
		this.mediaMap.put(media, progress);
	}

	/*
	 * get current Progress using media as the key
	 */
	public Progress getProgress(Media media) {
		return mediaMap.get(media);
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
}
