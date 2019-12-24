package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorite {

	private List<MovieItem> movieItemList;
	private double numberOfFavorites;

	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}

	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}

	public double getNumberOfFavorites() {
		return numberOfFavorites;
	}

	public void setNumberOfFavorites(double numberOfFavorites) {
		this.numberOfFavorites = numberOfFavorites;
	}

	public Favorite() {
		super();
		movieItemList = new ArrayList<>();
		numberOfFavorites = 0;
	}

}