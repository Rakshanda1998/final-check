package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieItem;

/**
 * Servlet implementation class ShowMovieItemListCustomerServlet
 */
@WebServlet({ "/ShowMovieItemListCustomerServlet", "/ShowMovieItemListCustomer" })
public class ShowMovieItemListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowMovieItemListCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
			List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();
			request.setAttribute("movieItemList", movieItemList);
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
