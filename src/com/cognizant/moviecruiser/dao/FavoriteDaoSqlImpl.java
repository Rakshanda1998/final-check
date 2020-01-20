package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.MovieItem;


public class FavoriteDaoSqlImpl implements FavoriteDao {
	
	public void addFavoriteItems(long userId, long movieItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "insert into favorite(ft_us_id, ft_pr_id) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieItemId);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<MovieItem> getAllFavoriteItems(long userId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		PreparedStatement ps;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		MovieItem movieItem = null;
		try {
			Favorite favorite = new Favorite();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append(
					"SELECT mv_id,me_title, mv_gross ,mv_active,mv_date_of_launch,mv_genre, mv_has_teaser FROM movie_item ")
					.append("INNER JOIN favorite ON mv_id = ft_pr_id WHERE ft_us_id = ?");
			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int movieItemId = resultSet.getInt(1);
				String title = resultSet.getString(2);
				long gross = resultSet.getLong(3);
				String active = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String genre = resultSet.getString(6);
				String hasTeaser = resultSet.getString(7);
				if (active != null && active.equalsIgnoreCase("Yes"))
					activeFlag = true;
				else
					activeFlag = false;
				if (hasTeaser != null && hasTeaser.equalsIgnoreCase("Yes"))
					hasTeaserFlag = true;
				else
					hasTeaserFlag = false;
				movieItem = new MovieItem(movieItemId, title, gross, activeFlag, date_of_launch, genre, hasTeaserFlag);
				movieItemList.add(movieItem);
			}
			favorite.setMovieItemList(movieItemList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (movieItemList.size() == 0) {
			throw new FavoriteEmptyException("Favorites List is Empty");
		}

		return movieItemList;

	}

	public void removeFavoriteItems(long userId, long movieItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "delete from favorite where ft_us_id=? and  ft_pr_id=? limit 1";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieItemId);
			int result = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
