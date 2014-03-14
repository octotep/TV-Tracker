package com.goddammitus.tvtracker.server;

public class MediaListProgress {
	private MediaProgress mediaProgress;
	private MediaList mediaList;

	public void addMedia(Media media) {
		mediaList.addMedia(media);
		mediaProgress.addMedia(media, false);
	}

	public Boolean isCompleted(Media media) {
		return mediaProgress.getProgress(media);
	}
}
