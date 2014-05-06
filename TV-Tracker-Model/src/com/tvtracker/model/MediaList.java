package com.tvtracker.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

/*
 * constructor
 */
public class MediaList implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private ArrayList<Media> list;

	/*
	 * initializes an ArrayList of Media objects, i.e. the MediaList
	 */
	public MediaList() {
		this.list = new ArrayList<Media>();
	}

	/*
	 * add a new Media object to the current MediaList (ArrayList<Media>)
	 */
	public void addMedia(Media media) {
		this.list.add(media);
	}

	/*
	 * returns the MediaList
	 */
	public ArrayList<Media> getMediaList() {
		return list;
	}

	/*
	 * get Media object from index of MediaList at "number"
	 */
	public Media getMedia(int number) {
		return this.list.get(number);
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
}
