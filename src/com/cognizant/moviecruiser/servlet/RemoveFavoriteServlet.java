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
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieItem;


/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet({ "/RemoveFavoriteServlet", "/RemoveFavorite" })
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RemoveFavoriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
			long movieItemId = Long.parseLong(request.getParameter("movieItemId"));
			favoriteDao.removeFavoriteItems(1, movieItemId);
			List<MovieItem> movieItemListCustomer = favoriteDao.getAllFavoriteItems(1);
			request.setAttribute("movieItemListCustomer", movieItemListCustomer);
			request.setAttribute("msg", "Movie Items removed successfully");
			RequestDispatcher rqd = request.getRequestDispatcher("ShowFavorite");
			rqd.forward(request, response);
		} catch (Exception ex) {
			RequestDispatcher rqd = request.getRequestDispatcher("favorites-empty.jsp");
			rqd.forward(request, response);

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
