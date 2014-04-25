package com.tvtracker.model;

import java.io.Serializable;

/**
 * 
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

public class Progress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer episodesSeenInCurrentSeason;
	private Integer currentSeason;
	
	public Progress() {
	
	}

	public Progress(Integer episodesSeenInCurrentSeason, Integer currentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
		this.currentSeason = currentSeason;
	}

	public void setEpisodesSeen(Integer episodesSeenInCurrentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
	}

	public void setCurrentSeason(Integer currentSeason) {
		this.currentSeason = currentSeason;
	}

	public Integer getEpisodesSeen() {
		return episodesSeenInCurrentSeason;
	}

	public Integer getCurrentSeason() {
		return currentSeason;
	}
}
