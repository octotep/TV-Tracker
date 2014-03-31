package com.tvtracker.model;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class Progress {
	private int episodesSeenInCurrentSeason;
	private int currentSeason;

	public Progress(int episodesSeenInCurrentSeason, int currentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
		this.currentSeason = currentSeason;
	}

	public void setEpisodesSeen(int episodesSeenInCurrentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
	}

	public void setCurrentSeason(int currentSeason) {
		this.currentSeason = currentSeason;
	}

	public int getEpisodesSeen() {
		return episodesSeenInCurrentSeason;
	}

	public int getCurrentSeason() {
		return currentSeason;
	}
}
