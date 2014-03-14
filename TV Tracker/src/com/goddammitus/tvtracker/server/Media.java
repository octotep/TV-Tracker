package com.goddammitus.tvtracker.server;

public class Media {
	private String name;

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
