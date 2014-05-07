package com.tvtracker.model;

import java.io.Serializable;
import java.util.Collections;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

/*
 * constructor
 */
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private MediaListProgress progress;
	private String password;

	/*
	 * empty constructor for serialization
	 */
	public Account() {

	}

	/*
	 * initializes an Account -- takes a username and password
	 */
	public Account(String name, String password) {
//		this.id = id;
		this.name = name;
		this.password = password;
		progress = new MediaListProgress(new MediaList(), new MediaProgress(Collections.<Media, Progress> emptyMap()));
	}

	/*
	 * returns the MediaListProgress for current account
	 */
	public MediaListProgress getMediaListProgress() {
		return this.progress;
	}

	/*
	 * returns username as a string
	 */
	public String getName() {
		return name;
	}

	/*
	 * sets username for login
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * sets password for login
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * returns password for login purposes
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * sets the MediaListProgress for the current account
	 */
	public void setMediaListProgress(MediaListProgress newProgress) {
		this.progress = newProgress;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
}
