package com.tvtracker.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class MediaList implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Media> list;

	public MediaList() {
		this.list = new ArrayList<Media>();
	}

	public void addMedia(Media media) {
		this.list.add(media);
	}
	
	public MediaList getMediaList() {
		return this;
	}
	
}
