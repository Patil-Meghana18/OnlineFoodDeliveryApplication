<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.foodApp.modules.*,java.util.List,com.foodApp.DaoImpl.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Status</title>
</head>
<body>
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
<div class="content">
    <div class="message success-message">
        Order placed Successfully!
    </div>
    <a href="home.jsp" class="home-button">Go to Home</a>
</div>

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
<style>
@charset "UTF-8";

/* Basic navbar styling */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    overflow-x: hidden;
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
    background-color: #FF5722; /* Hover background color */
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

/* Hero section styles */
.hero-section {
    padding: 100px 20px;
    background: url('https://via.placeholder.com/1200x400') no-repeat center center;
    background-size: cover;
    color: white;
    text-align: center;
    margin-top: 0; /* Remove the margin-top */
    min-height: 400px;
}
/* Content styling */
.content {
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 20px;
    min-height: calc(100vh - 100px); /* Ensures the content takes full height minus the navbar and footer */
}

.message {
    padding: 20px;
    margin: 20px;
    border-radius: 8px;
    width: 80%;
    max-width: 600px;
    font-size: 1.2em;
    font-weight: bold;
    text-align: center; /* Center the text inside the message box */
}

/* Ensures the success message is centered within the content area */
.success-message {
    background-color: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
}

/* Optional: If you want the button to be centered as well */
.home-button {
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 1.1em;
    transition: background-color 0.3s ease, transform 0.2s ease;
    text-align: center;
}
/* Footer styling */
.footer {
    background-color: #004d00;
    color: white;
    text-align: center;
    padding: 20px 10px;
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
}

.footer-content {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    flex-wrap: wrap;
    gap: 20px;
    margin-bottom: 10px;
}

.footer-left, .footer-center, .footer-right {
    flex: 1;
    min-width: 200px;
}

.footer-logo {
    height: 40px;
    margin-bottom: 10px;
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

/* Responsive design for smaller screens */
@media (max-width: 768px) {
    .navbar {
        flex-direction: column;
        align-items: flex-start;
    }

    .navbar-center {
        margin-top: 10px;
    }

    .message {
        width: 90%;
        font-size: 1em;
    }

    .footer-content {
        flex-direction: column;
        align-items: center;
    }

    .footer-left, .footer-center, .footer-right {
        text-align: center;
    }
}


</style>
 <script src="home.js"></script></script>

</body>
</html>
