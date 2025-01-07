package com.foodApp.Servlets;

import java.io.IOException;

import com.foodApp.DaoImpl.UserDaoImpl;
import com.foodApp.modules.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		 String email=request.getParameter("email");
    	   	 String userName=request.getParameter("userName");
    	   	 String phoneNumber=request.getParameter("phoneNumber");
    	   	 String cpassword=request.getParameter("cpassword");
    	   	 String address=request.getParameter("address");
    		 String password=request.getParameter("password");
    		    if (cpassword != null && password != null && cpassword.equals(password)) {
    	            UserDaoImpl userDao = new UserDaoImpl();
    	            User user = new User(userName, email, phoneNumber, password, address);
    	            int x = userDao.addUser(user);
    	            response.sendRedirect("login.jsp");
    	        } else {
    	            response.sendRedirect("reRegister.jsp");
    	        }
    	   	
    		
    		
    		
    		
	}

	
}
