package com.tvtracker.model;

import java.io.Serializable;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class Media implements Serializable {
	private String name;

	public Media() {

	}

	public Media(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
}
