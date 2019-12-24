package com.cognizant.moviecruiser.dao;

public class FavoriteEmptyException extends Exception {
	public FavoriteEmptyException() {
		super("***Favorites List Is Empty***\n");
	}

	public FavoriteEmptyException(String message) {
		super(message);
	}
}
