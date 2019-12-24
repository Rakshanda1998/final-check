package com.cognizant.moviecruiser.dao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionImlpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("***Admin List Details***");
			testGetMovieItemListAdmin();
			System.out.println("\n***Customer List Details***");
			testGetMovieItemListCustomer();
			System.out.println("\n***Modified Coustomer List***");
			testModifyMenuItem();
			testGetMovieItemListAdmin();

		} catch (ParseException ex) {
			System.out.println(ex);
		}

	}

	private static void testGetMovieItemListAdmin() throws ParseException {
		// TODO Auto-generated method stub
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();

		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();

		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	private static void testGetMovieItemListCustomer() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();

		List<MovieItem> customerList = movieItemDao.getMovieItemListCustomer();

		NumberFormat numFormat = NumberFormat.getInstance();

		numFormat.setGroupingUsed(true);

		for (MovieItem x : customerList) {
			System.out.println(x);

		}

	}

	private static void testModifyMenuItem() throws ParseException {
		// TODO Auto-generated method stub
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		MovieItem m = new MovieItem(4, "Star War", 8547213695L, true, DateUtil.convertToDate("26/01/2017"), "Tragedy",
				true);
		movieItemDao.modifyMovieItem(m);

	}

}