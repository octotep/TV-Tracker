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
	private int id;
	private static final long serialVersionUID = 1L;
	private Integer episodesSeenInCurrentSeason;
	private Integer currentSeason;
	private Integer episodesInCurrentSeason;

	/*
	 * empty constructor for serialization
	 */
	public Progress() {

	}

	/*
	 * initializes Progress -- uses Integers to track episode count and seasons
	 */
	public Progress(Integer currentSeason, Integer episodesSeenInCurrentSeason, Integer episodesInCurrentSeason) {
//		this.id = id;
		this.episodesSeenInCurrentSeason = episodesSeenInCurrentSeason;
		this.episodesInCurrentSeason = episodesInCurrentSeason;
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
	 * set number of episodes in the current season
	 */
	public void setEpisodesInCurrentSeason(Integer episodesInCurrentSeason) {
		this.episodesInCurrentSeason = episodesInCurrentSeason;
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

	/*
	 * return number of episodes in current season
	 */
	public Integer getEpisodesInCurrentSeason() {
		return episodesInCurrentSeason;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}
}
