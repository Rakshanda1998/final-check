package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieItemDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieItem;

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet({ "/AddToFavoriteServlet", "/AddToFavorite" })
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddToFavoriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			long userId = 1L;
			long movieItemId = Long.parseLong(request.getParameter("movieItemId"));
			FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();	
			favoriteDao.addFavoriteItems(1, movieItemId);
			MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
			List<MovieItem> movieItemListCustomer = movieItemDao.getMovieItemListCustomer();
			request.setAttribute("movieItemList",movieItemListCustomer);
			
			request.setAttribute("msg", "Items Added Successfully");
			RequestDispatcher rqd = request.getRequestDispatcher("movie-list-customer.jsp");
			rqd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
