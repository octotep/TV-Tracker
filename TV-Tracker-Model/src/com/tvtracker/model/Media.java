package com.tvtracker.model;

import java.io.Serializable;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

/*
 * constructor
 */
public class Media implements Serializable {
	private int id;
	private String name;

	/*
	 * empty constructor for serializable
	 */
	public Media() {

	}

	/*
	 * creates name for this instance of Media
	 */
	public Media(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * returns name of this instance of Media
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * sets new name for this instance of Media
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
}
