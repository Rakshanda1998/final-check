package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoCollectionIpmltest {

	public static void main(String[] args) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		try {
			testGetAllFavoriteItems();
			testAddFavoriteItem();
			testGetAllFavoriteItems();
			testRemoveFavoriteItem();
			testGetAllFavoriteItems();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void testAddFavoriteItem() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		try {
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
			favoriteDao.addFavoriteItems(1, 5L);
			favoriteDao.addFavoriteItems(1, 3L);
			List<MovieItem> movieItemListCustomer = favoriteDao.getAllFavoriteItems(1);
			System.out.println("***Favorite Movies to Check-Out***");
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static void testGetAllFavoriteItems() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		try {
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
			List<MovieItem> movieItemListCustomer = favoriteDao.getAllFavoriteItems(1);
			System.out.println("\n***User favorite Movies***");
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void testRemoveFavoriteItem() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		System.out.println("\n***Favorite Movies Removed by Customer***");
		try {
			favoriteDao.removeFavoriteItems(1, 2L);
			favoriteDao.removeFavoriteItems(1, 5L);
			// favoriteDao.removeFavoriteItems(1, 3L);
			List<MovieItem> movieItemListCustomer = favoriteDao.getAllFavoriteItems(1);
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (FavoriteEmptyException ex) {
			System.out.println(ex.getMessage());
		}

	}

}