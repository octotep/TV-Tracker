package com.goddammitus.tvtracker.server;

import java.util.ArrayList;
import java.util.Map;

public class MediaProgress {
	private Map<Media, Boolean> mediaMap;

	public MediaProgress(Map<Media, Boolean> mediaMap) {
		this.mediaMap = mediaMap;
	}

	public void addMedia(Media media, Boolean progress) {
		this.mediaMap.put(media, progress);
	}

	public Boolean getProgress(Media media) {
		return mediaMap.get(media);
	}
}
