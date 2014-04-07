package com.tvtracker.model;

import java.io.Serializable;
import java.util.Collections;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class Account implements Serializable {
	private String name;
	private MediaListProgress progress;
	private String password;

	public Account(String name, String password) {
		this.name = name;
		this.password = password;
		progress = new MediaListProgress(new MediaList(), new MediaProgress(Collections.<Media, Progress> emptyMap()));
	}
	public Account() {
		name = "";
		password = "";
		progress = new MediaListProgress(new MediaList(), new MediaProgress(Collections.<Media, Progress> emptyMap()));
	}

	public MediaListProgress getMediaListProgress() {
		return this.progress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setMediaListProgress(MediaListProgress newProgress) {
		this.progress = newProgress;
	}
}
