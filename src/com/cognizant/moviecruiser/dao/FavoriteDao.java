package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoriteDao {
	public void addFavoriteItems(long userId, long movieItemId) throws FavoriteEmptyException;

	public List<MovieItem> getAllFavoriteItems(long userId) throws FavoriteEmptyException;

	public void removeFavoriteItems(long userId, long movieItemId);
}
