package com.tvtracker.model;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class Account {
	private String name;
	private MediaListProgress progress;
	private String pwdHash;

	public MediaListProgress getMediaListProgress() {
		return this.progress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setMediaListProgress(MediaListProgress newProgress) {
		this.progress = newProgress;
	}
}
