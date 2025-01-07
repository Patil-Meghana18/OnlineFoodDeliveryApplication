package com.foodApp.Servlets;

import java.io.IOException;
import java.io.OutputStream;

import com.foodApp.DaoImpl.RestaurantDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));  
		  
	      // Retrieve the image data from the database  
	      byte[] imageData =new  RestaurantDaoImpl().getImage(restaurantId);  
	  
	      // Set the response content type to image/jpeg (or the appropriate type)  
	      response.setContentType("image/jpeg");  
	  
	      // Write the image data to the response output stream  
	      OutputStream outputStream = response.getOutputStream();  
	      outputStream.write(imageData);  
	      outputStream.close();  
	  */
	}

	
}
