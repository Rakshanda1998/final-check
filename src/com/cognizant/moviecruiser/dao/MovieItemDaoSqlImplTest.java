package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;


public class MovieItemDaoSqlImplTest {
	public static void main(String[] args) throws SQLException {
		try {
			System.out.println("***Admin Movie Details***");
			testGetMovieItemListAdmin();

			 System.out.println("\n***Customer movie Details***");
			 testGetMovieItemListCustomer(); 
			 testModifyMovieItem();
			 

			System.out.println("\n***Modified Customer List***");
			testGetMovieItemListAdmin();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static void testModifyMovieItem() {
		try {
		MovieItem m = new MovieItem(1, "Frozen2", 1472683269, true, DateUtil.convertToDate("26/01/2017"),
				"Science Fiction", true);
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		movieItemDao.modifyMovieItem(m);
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	private static void testGetMovieItemListCustomer() {
		try {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();

		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	

	private static void testGetMovieItemListAdmin() {
		try {
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			movieItemDao.getMovieItemListAdmin();
			List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();

			for (MovieItem x : movieItemList) {
				System.out.println(x);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
