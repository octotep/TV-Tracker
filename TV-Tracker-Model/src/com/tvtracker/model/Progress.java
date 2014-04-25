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
public class Progress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer episodesSeenInCurrentSeason;
	private Integer currentSeason;
	
	/*
	 * empty constructor for serialization
	 */
	public Progress() {
	
	}
	
	/*
	 * initializes Progress -- uses Integers to track episode count and seasons
	 */
	public Progress(Integer episodesSeenInCurrentSeason, Integer currentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
		this.currentSeason = currentSeason;
	}
	
	/*
	 * set episode count
	 */
	public void setEpisodesSeen(Integer episodesSeenInCurrentSeason) {
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
	}
	
	/*
	 * set season count
	 */
	public void setCurrentSeason(Integer currentSeason) {
		this.currentSeason = currentSeason;
	}

	/*
	 * return episode count
	 */
	public Integer getEpisodesSeen() {
		return episodesSeenInCurrentSeason;
	}
	
	/*
	 * return season count
	 */
	public Integer getCurrentSeason() {
		return currentSeason;
	}
}
