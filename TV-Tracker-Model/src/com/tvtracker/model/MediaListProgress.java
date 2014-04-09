package com.tvtracker.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaListProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	private MediaProgress mediaProgress;
	private MediaList mediaList;

	public MediaListProgress() {
<<<<<<< HEAD
		this.mediaList = new MediaList();
		this.mediaProgress = new MediaProgress(new HashMap<Media, Progress>());
	}
	
=======

	}

>>>>>>> refs/remotes/chris/master
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
	
	public void setMediaList(MediaList mediaList) {
		this.mediaList = mediaList;
	}
	
	public void setMediaProgress(MediaProgress mediaProgress) {
		this.mediaProgress = mediaProgress;
	}
}
