package com.tvtracker.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	private HashMap<Media, Progress> mediaMap;

	public MediaProgress() {

	}

	public MediaProgress(Map<Media, Progress> mediaMap) {
		this.mediaMap = new HashMap<Media, Progress>(mediaMap);
	}

	public void addMedia(Media media, Progress progress) {
		this.mediaMap.put(media, progress);
	}

	public Progress getProgress(Media media) {
		return mediaMap.get(media);
	}
}
