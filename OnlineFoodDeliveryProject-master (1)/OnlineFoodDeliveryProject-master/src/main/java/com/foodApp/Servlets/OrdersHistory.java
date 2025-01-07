package com.foodApp.Servlets;

import java.io.IOException;
import java.util.List;

import com.foodApp.DaoImpl.OrderHistoryDaoImpl;
import com.foodApp.modules.OrderHistory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ordersHistory")
public class OrdersHistory extends HttpServlet {
    // Changed to doGet to handle GET requests from anchor tags
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId")); // Retrieve userId parameter from URL
        OrderHistoryDaoImpl dao = new OrderHistoryDaoImpl();
        List<OrderHistory> allOrderHistory = dao.getAllOrderHistory(userId); // Get order history for the user
        HttpSession session = request.getSession();
        session.setAttribute("orderHistoryList", allOrderHistory); // Store order history in session
        response.sendRedirect("orderHistory.jsp"); // Redirect to orderHistory.jsp
    }
}
