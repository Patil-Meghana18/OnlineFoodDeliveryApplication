package com.foodApp.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.foodApp.DaoImpl.RestaurantDaoImpl;
import com.foodApp.modules.Restaurant;
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	RestaurantDaoImpl restaurant = new RestaurantDaoImpl();
   	//	  List<Restaurant> allRestaurant = restaurant.getAllRestaurant();
   	//	  HttpSession session = request.getSession();
   	//S	  session.setAttribute("restaurantList", allRestaurant);
   		  response.sendRedirect("home.jsp");
   		
   		
		
	}

}
