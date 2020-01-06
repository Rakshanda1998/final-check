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
import com.cognizant.moviecruiser.model.MovieItem;


/**
 * Servlet implementation class ShowFavoriteServlet
 */
@WebServlet({ "/ShowFavoriteServlet", "/ShowFavorite" })
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowFavoriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
			try {
			List<MovieItem> movieItemListCustomer = favoriteDao.getAllFavoriteItems(1);
			request.setAttribute("movieItemList", movieItemListCustomer);
			double noOfFavorite = 0;
			for (MovieItem movieItem : movieItemListCustomer) {
				noOfFavorite += movieItem.getGross();
				request.setAttribute("NoOfFavorite", noOfFavorite);
			}		
			RequestDispatcher rqd = request.getRequestDispatcher("favorites.jsp");
			rqd.forward(request, response);
		} catch (Exception ex) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
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
