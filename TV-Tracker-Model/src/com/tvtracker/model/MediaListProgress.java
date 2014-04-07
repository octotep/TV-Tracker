package com.tvtracker.model;

import java.io.Serializable;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaListProgress implements Serializable {
	private MediaProgress mediaProgress;
	private MediaList mediaList;

	public MediaListProgress() {

	}

	public MediaListProgress(MediaList mediaList, MediaProgress mediaProgress) {
		this.mediaList = mediaList;
		this.mediaProgress = mediaProgress;
	}

	public void setMediaList(MediaList list) {
		this.mediaList = list;
	}

	public void setMediaProgress(MediaProgress progress) {
		this.mediaProgress = progress;
	}

	public void addMedia(Media media, int episodesSeenInCurrentSeason, int currentSeason) {
		mediaList.addMedia(media);
		mediaProgress.addMedia(media, new Progress(episodesSeenInCurrentSeason, currentSeason));
	}

	public Progress currentProgress(Media media) {
		return mediaProgress.getProgress(media);
	}
}
