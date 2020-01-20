package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoSqlImplTest {
	public static void main(String[] args) throws FavoriteEmptyException {
		testAddFavoriteItem();
		testRemoveFavoriteItems();
		testGetAllFavoriteItems();
	}

	private static void testGetAllFavoriteItems() throws FavoriteEmptyException {
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao favoriteDao = favoriteDaoSqlImpl;
		List<MovieItem> movieItemList = favoriteDao.getAllFavoriteItems(1);
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	private static void testRemoveFavoriteItems() throws FavoriteEmptyException {
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao favoriteDao = favoriteDaoSqlImpl;

		try {
			favoriteDao.removeFavoriteItems(1, 4);
		} catch (Exception e) {
			throw new FavoriteEmptyException("Favorites is Empty");
		}
	}

	private static void testAddFavoriteItem() throws FavoriteEmptyException{
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao favoriteDao = favoriteDaoSqlImpl;
		favoriteDao.addFavoriteItems(1, 4);
		favoriteDao.addFavoriteItems(1, 3);
	}
}
