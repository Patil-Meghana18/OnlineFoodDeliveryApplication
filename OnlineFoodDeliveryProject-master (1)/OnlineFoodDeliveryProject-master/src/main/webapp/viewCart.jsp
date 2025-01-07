<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.foodApp.modules.*, java.util.*, com.foodApp.DaoImpl.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
  
        @charset "UTF-8";

        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            overflow-x: hidden;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .wrapper {
            flex: 1; /* This allows the wrapper to take up remaining space */
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .content {
            padding: 20px;
            flex-grow: 1; /* This makes the content area grow and push the footer down */
            padding-bottom: 50px; /* Add some space between content and footer */
        }

        /* Navbar styles */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: #004d00; /* Dark green background */
            color: white;
        }

        .navbar-left {
            display: flex;
            align-items: center;
        }

        .navbar-left .logo {
            height: 40px;
            margin-right: 10px;
        }

        .navbar-left .company-name {
            font-size: 24px;
            font-weight: 600;
        }

        .navbar-center {
            font-size: 18px;
            font-weight: 500;
            text-align: center;
            padding-top: 5px;
        }

        .nav-menu {
            display: flex;
            list-style-type: none;
            margin: 0;
            padding: 0;
            align-items: center;
        }

        .nav-menu li {
            position: relative;
            margin-left: 20px;
        }

        .nav-menu li a {
            color: white;
            text-decoration: none;
            font-size: 16px;
            padding: 6px 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
            vertical-align: middle;
        }

        .nav-menu li a:hover {
            background-color: #FF5722; /* Hover background color */
            color: #fff;
        }

        .dropdown .dropbtn {
            background: none;
            border: none;
            color: white;
            cursor: pointer;
            font-size: 16px;
            padding: 6px 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
            margin-top: 5px; /* Lower the profile button slightly */
        }

        .dropdown .dropbtn:hover {
            background-color: #FF5722; /* Hover background color */
        }

        .dropdown-content {
            display: none;
            position: absolute;
            right: 0;
            background-color: #004d00;
            min-width: 180px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 5px;
            margin-top: 5px; /* Close to the button to prevent gap */
        }

        .dropdown-content a {
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .dropdown-content a:hover {
            background-color: #FF5722; /* Hover background color */
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #008000; /* Hover background color */
        }

        /* Additional styling */
        .nav-menu li:hover .dropdown-content {
            display: block;
        }

        .dropdown-content a {
            white-space: nowrap;
        }

        /* Keep the dropdown open when hovering over the button or the dropdown content */
        .nav-menu li:hover .dropdown-content,
        .dropdown-content:hover {
            display: block;
        }

        /* No need for JS toggle in this case */
        .show {
            display: block;
        }

        .p{
            color: blue;
            text-align: center;
            padding: 5px 0; /* Reduced padding */
            margin-top: 6px; /* Reduced margin */
        }

        /* Adjustments for cart and content */
        .cart {
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        .cart table {
            width: 100%;
            border-collapse: collapse;
            background-color: #FFFFFF; /* White background */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Soft shadow */
        }

        .cart th, .cart td {
            border: 1px solid #DDDDDD; /* Light Gray border */
            padding: 10px;
            text-align: left;
        }

        .cart th {
            background-color: #FF5722; /* Orange */
            color: #FFFFFF; /* White */
        }

        .cart tr:nth-child(even) {
            background-color: #F5F5F5; /* Light Gray */
        }

        .cart tr:hover {
            background-color: #FFEBEE; /* Light Pink */
        }

        .quantity-cell {
            text-align: center;
        }

        .remove-btn {
            background-color: #E53935; /* Deep Red */
            color: #FFFFFF; /* White */
            border: none;
            border-radius: 4px;
            padding: 5px 10px;
            cursor: pointer;
        }

        .remove-btn:hover {
            background-color: #FF5722; /* Darker Red */
        }

        .cart-summary {
            margin-top: 10px;
            padding: 20px;
            background-color: #F5F5F5; /* Light Gray */
            border: 1px solid #DDDDDD; /* Light Gray border */
            border-radius: 4px;
        }

        .checkout-btn {
            background-color: #4CAF50; /* Green */
            color: #FFFFFF; /* White */
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            display: inline-block;
            margin-top: 10px; /* Space above the "Edit Address" button */
        }

        .checkout-btn:hover {
            background-color: #FF5722; /* Darker Green */
        }

        .add-more {
            background-color: #4CAF50; /* Green */
            color: #FFFFFF; /* White */
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            margin-left: 600px;
            font-size: 16px;
            cursor: pointer;
        }

        .add-more:hover {
            background-color: #FF5722; /* Darker Green */
        }

        /* Alternatively, add margin-bottom to the last section before the footer */
        .cart-summary {
            margin-top: 10px; /* Space above each cart-summary section */
            padding: 20px;
            background-color: #F5F5F5; /* Light Gray */
            border: 1px solid #DDDDDD; /* Light Gray border */
            border-radius: 4px;
            margin-bottom: 20px; /* Space below the last cart-summary section */
        }

        .cart-summary1 {
            margin-top: 10px; /* Space above each cart-summary section */
            padding: 20px;
            background-color: #F5F5F5; /* Light Gray */
            border: 1px solid #DDDDDD; /* Light Gray border */
            border-radius: 4px;
            margin-bottom: 30px; /* Space below the last cart-summary section */
        }

        /* Basic footer styling */
        .footer {
            background-color: #004d00;
            color: white;
            padding: 20px;
            text-align: center;
            width: 100%;
            position: relative; /* Changed from fixed to relative */
            z-index: 1000;
        }

        .footer-content {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            flex-wrap: wrap;
            gap: 20px;
        }

        .footer-left, .footer-center, .footer-right {
            flex: 1;
            min-width: 200px;
        }

        .footer-logo {
            height: 40px;
            margin-bottom: 10px;
        }

        .footer-left p {
            margin: 0;
        }

        .footer-center h3, .footer-right h3 {
            margin-top: 0;
        }

        .footer-center p {
            margin: 5px 0;
        }

        .footer-center i {
            margin-right: 5px;
        }

        .footer-right a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            font-size: 20px;
        }

        .footer-right a:hover {
            color: #f0f0f0;
        }

        .footer-bottom {
            border-top: 1px solid #444;
            padding: 10px 0;
            margin-top: 20px;
        }

        .footer-bottom p {
            margin: 0;
        }

        .footer-bottom a {
            color: white;
            text-decoration: none;
        }

        .footer-bottom a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="content">
      <nav class="navbar">
        <div class="navbar-left">
            <img src="/foodApp/images/logo.png" alt="Company Logo" class="logo">
            <span class="company-name">Kane Foods</span>
        </div>
        <div class="navbar-center">
            <% User user = (User) session.getAttribute("loginUser"); %>
            <% if (user != null) { %>
                <span class="user-welcome">Welcome, <%= user.getUserName() %></span>
            <% } %>
        </div>
        <ul class="nav-menu">
            <li><a href="home.jsp"><i class="fas fa-home"></i> Home</a></li>
            <% if (user != null) { %>
                <li><a href="viewCart.jsp"><i class="fas fa-cart-shopping"></i> View Cart</a></li>
                <li><a href="ordersHistory?userId=<%= user.getUserId() %>"><i class="fas fa-history"></i> Order History</a></li>
                <li class="dropdown">
                    <button class="dropbtn">
                        <i class="fas fa-user"></i> Profile <i class="fas fa-caret-down"></i>
                    </button>
                    <div id="dropdown-content" class="dropdown-content">
                        <a href="viewProfile.jsp"><i class="fas fa-user-circle"></i> View Profile</a>
                        <a href="updateProfile.jsp"><i class="fas fa-user-edit"></i> Update Profile</a>
                        <a href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                    </div>
                </li>
            <% } else { %>
                <li><a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a></li>
                <li><a href="register.jsp"><i class="fas fa-user-plus"></i> Register</a></li>
            <% } %>
        </ul>
    </nav>
            <p class="p">Review and manage your cart items.</p>
        

        <% Cart cart = (Cart) session.getAttribute("cart"); 
        float total;
        if (cart != null&& user!=null) { %>
        <section class="cart">
            <table>
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    Map<Integer,CartItem> map = cart.getItems();
                    Set<Map.Entry<Integer,CartItem>> set = map.entrySet();
                    float sum = 0;
                    if (set != null) {
                        for (Map.Entry<Integer,CartItem> cartMap : set) { %>
                    <tr>
                        <td><%= cartMap.getValue().getMenuName() %></td>
                        <td class="quantity-cell">
                            <form action="viewCart" method="get">
                                <input type="hidden" name="itemId" value="<%= cartMap.getValue().getItemId() %>">
                                <input type="hidden" name="action" value="update">
                                <input type="number" min="1" name="quantity" value="<%= cartMap.getValue().getQuantity() %>">
                                <input type="submit" value="Update" class="remove-btn">
                            </form>
                        </td>
                        <td><%= cartMap.getValue().getPrice() %></td>
                        <td><%= cartMap.getValue().getSubTotal() %></td>
                        <td>
                            <form action="viewCart" method="get">
                                <input type="hidden" name="itemId" value="<%= cartMap.getValue().getItemId() %>">
                                <input type="hidden" name="action" value="delete">
                                <input type="submit" value="Remove" class="remove-btn">
                            </form>
                        </td>
                    </tr>
                    <% sum += cartMap.getValue().getSubTotal(); } } %>     
                </tbody>
            </table>

            <div class="cart-summary">
                <p><strong>Subtotal:</strong> <%= sum %></p>
                <p><strong>Shipping:</strong> 
                    <% int tip; if (sum < 199) { tip = 50; out.print(tip); } else { tip = 0; out.println(tip); } %>
                </p>
                <p><strong>Total:</strong> <%= total = sum + tip %></p>
                <a href="checkout.jsp?total=<%= total %>"><button class="checkout-btn">Proceed to Checkout</button></a>
                <a href="menu.jsp"><button class="add-more">Add More</button></a>
            </div>
            <div class="cart-summary1">
                <p><strong>Delivery Address: </strong><%= user.getAddress() %></p>
                <a href="update.jsp"><button class="checkout-btn">Edit</button></a>
            </div>     
        </section>
        <% } else if(user==null){
        	response.sendRedirect("login.jsp");
        }else { %>
        <div class="cart-summary">
            <p><strong>Cart is empty</strong></p>
            <a href="menu.jsp"><button class="add-more">Add More</button></a>
            </div>
        <% } %>
    </div> <!-- End of .content -->
    
    <footer class="footer">
    <div class="footer-content">
        <div class="footer-left">
            <img src="/foodApp/images/logo.png" alt="Company Logo" class="footer-logo">
            <p>&copy; 2024 Company Name. All rights reserved.</p>
        </div>
        <div class="footer-center">
            <h3>Contact Us</h3>
            <p><i class="fas fa-map-marker-alt"></i> 123 Food Street, Tasty Town, FL 12345</p>
            <p><i class="fas fa-phone"></i> +1 (234) 567-8901</p>
            <p><i class="fas fa-envelope"></i> <a href="mailto:support@company.com">support@company.com</a></p>
        </div>
        <div class="footer-right">
            <h3>Follow Us</h3>
            <a href="#" class="social-icon"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-twitter"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-instagram"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-linkedin-in"></i></a>
        </div>
    </div>
    <div class="footer-bottom">
        <p><a href="#">Terms of Service</a> | <a href="#">Privacy Policy</a></p>
    </div>
</footer>


</div> <!-- End of .wrapper -->
 <script src="home.js"></script></body>
</html>
