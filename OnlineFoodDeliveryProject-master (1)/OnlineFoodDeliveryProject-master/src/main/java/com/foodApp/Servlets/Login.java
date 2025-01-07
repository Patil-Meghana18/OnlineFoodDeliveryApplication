package com.foodApp.Servlets;

import java.io.IOException;

import com.foodApp.DaoImpl.UserDaoImpl;
import com.foodApp.modules.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    
	    

	    
	    UserDaoImpl dao=new UserDaoImpl();
	    User user=dao.getUser(email);
	    System.out.println(user);
	    if(user!=null&&password.equals(user.getPassword())) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser",user);
	    	response.sendRedirect("home.jsp");
	    	
	    	
	    }else {
	    	
	    	response.sendRedirect("reLogin.jsp");
	    }
	   	
   		
}

}
