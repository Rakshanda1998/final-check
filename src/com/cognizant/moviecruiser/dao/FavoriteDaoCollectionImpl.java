package com.cognizant.moviecruiser.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorites;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorite());
		}
	}

	@Override
	public void addFavoriteItems(long userId, long movieItemId) {
		// TODO Auto-generated method stub
		try {
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);

			if (userFavorites.containsKey(userId)) {
				Favorite favorite = userFavorites.get(userId);
				favorite.getMovieItemList().add(movieItem);
			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieItemList().add(movieItem);
				userFavorites.put(userId, favorite);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<MovieItem> getAllFavoriteItems(long userId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		Favorite favorite = userFavorites.get(userId);
		int numberOfFavorites = 0;
		if (favorite == null || favorite.getMovieItemList()==null || movieItemList.isEmpty()) {
			throw new FavoriteEmptyException();
		} else {
			for (MovieItem movieItem : movieItemList) {
				numberOfFavorites += movieItem.getGross();
			}
		}
		favorite.setNumberOfFavorites(numberOfFavorites);
		return movieItemList;
	}

	@Override
	public void removeFavoriteItems(long userId, long movieItemId) {
		// TODO Auto-generated method stub
		List<MovieItem> movieItemList = userFavorites.get(userId).getMovieItemList();
		for (int a = 0; a < movieItemList.size(); a++) {
			if (movieItemList.get(a).getId() == movieItemId) {
				movieItemList.remove(a);
				break;
			}
		}

	}

}