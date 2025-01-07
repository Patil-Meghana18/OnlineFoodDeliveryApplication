package com.foodApp.Servlets;

import java.io.IOException;
import java.util.List;

import com.foodApp.DaoImpl.MenuDaoImpl;
import com.foodApp.modules.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuSerlet
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int restauarntId =Integer.parseInt( request.getParameter("restaurantId"));
		  MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		  List<Menu> allMenu = menuDaoImpl.getAllMenu(restauarntId);
		  HttpSession session = request.getSession();
		  session.setAttribute("menuList", allMenu);
		  session.setAttribute("restaurantId",restauarntId);
		  response.sendRedirect("menu.jsp");
		  
		  
    	
    	
    	
    	}

	
}
