package com.foodApp.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.foodApp.DaoImpl.MenuDaoImpl;
import com.foodApp.DaoImpl.OrderHistoryDaoImpl;
import com.foodApp.DaoImpl.OrderItemDaoImpl;
import com.foodApp.DaoImpl.OrderTableImpl;
import com.foodApp.DaoImpl.UserDaoImpl;
import com.foodApp.DaoImpl.RestaurantDaoImpl;
import com.foodApp.modules.Menu;
import com.foodApp.modules.OrderHistory;
import com.foodApp.modules.OrderItem;
import com.foodApp.modules.OrderTable;
import com.foodApp.modules.User;
import com.foodApp.modules.Restaurant;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDaoImpl userDao = new UserDaoImpl();
        RestaurantDaoImpl restaurantDao = new RestaurantDaoImpl();
        MenuDaoImpl menuDao = new MenuDaoImpl();
        OrderTableImpl orderTableDao = new OrderTableImpl();
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        OrderHistoryDaoImpl orderHistoryDao = new OrderHistoryDaoImpl();
        
        System.out.println("Welcome to Food App");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Restaurants");
            System.out.println("3. Manage Menus");
            System.out.println("4. Manage OrderTable");
            System.out.println("5. Manage Order Items");
            System.out.println("6. Manage Order History");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                manageUsers(scanner, userDao);
                break;
            case 2:
                manageRestaurants(scanner, restaurantDao);
                break;
            case 3:
                manageMenus(scanner, menuDao);
                break;
            case 4:
            	manageOrders(scanner, orderTableDao);
                break;
            case 5:
            	manageOrderItem(scanner, orderItemDao);
                break;
            case 6:
            	manageOrderHistory(scanner, orderHistoryDao);
                break;
            case 7:
                System.out.println("Exiting the application. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageUsers(Scanner scanner, UserDaoImpl userDao) {
        System.out.println("\nUser Management Options:");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.println("3. View User by Email");
        System.out.println("4. Update User");
        System.out.println("5. Delete User");
        System.out.println("6. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        switch (choice) {
            case 1:
                System.out.println("Enter Username:");
                String userName = scanner.nextLine();
                System.out.println("Enter Email:");
                String email = scanner.nextLine();
                System.out.println("Enter Phone Number:");
                String phone = scanner.nextLine();
                System.out.println("Enter Password:");
                String password = scanner.nextLine();
                System.out.println("Enter Address:");
                String address = scanner.nextLine();

                User newUser = new User();
                newUser.setUserName(userName);
                newUser.setEmail(email);
                newUser.setPhoneNumber(phone);
                newUser.setPassword(password);
                newUser.setAddress(address);

                int status = userDao.addUser(newUser);
                System.out.println(status > 0 ? "User added successfully!" : "Failed to add user.");
                break;
            case 2:
                List<User> allUsers = userDao.getAllUser();
                allUsers.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Enter User Email:");
                String userEmail = scanner.nextLine();
                User fetchedUser = userDao.getUser(userEmail);
                System.out.println(fetchedUser != null ? fetchedUser : "User not found.");
                break;
            case 4:
                System.out.println("Enter User Email for Update:");
                userEmail = scanner.nextLine();
                fetchedUser = userDao.getUser(userEmail);
                if (fetchedUser != null) {
                    System.out.println("Enter New Username:");
                    userName = scanner.nextLine();
                    System.out.println("Enter New Phone Number:");
                    phone = scanner.nextLine();
                    System.out.println("Enter New Password:");
                    password = scanner.nextLine();
                    System.out.println("Enter New Address:");
                    address = scanner.nextLine();

                    fetchedUser.setUserName(userName);
                    fetchedUser.setPhoneNumber(phone);
                    fetchedUser.setPassword(password);
                    fetchedUser.setAddress(address);

                    status = userDao.updateUser(fetchedUser);
                    System.out.println(status > 0 ? "User updated successfully!" : "Failed to update user.");
                } else {
                    System.out.println("User not found.");
                }
                break;
            case 5:
                System.out.println("Enter User Email to Delete:");
                userEmail = scanner.nextLine();
                status = userDao.deleteUser(userEmail);
                System.out.println(status > 0 ? "User deleted successfully!" : "Failed to delete user.");
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    

    private static void manageRestaurants(Scanner scanner, RestaurantDaoImpl restaurantDao) {
        System.out.println("\nRestaurant Management:");
        System.out.println("1. Add Restaurant");
        System.out.println("2. Fetch All Restaurants");
        System.out.println("3. Fetch Restaurant by ID");
        System.out.println("4. Update Restaurant");
        System.out.println("5. Delete Restaurant");
        System.out.println("6. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                // Add Restaurant
                System.out.println("Enter Restaurant ID:");
                int restaurantId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                System.out.println("Enter Restaurant Name:");
                String name = scanner.nextLine();
                System.out.println("Enter Cuisine Type:");
                String cuisineType = scanner.nextLine();
                System.out.println("Enter Delivery Time (in minutes):");
                String deliveryTime = scanner.nextLine();
                System.out.println("Enter Address:");
                String address = scanner.nextLine();
                System.out.println("Enter Rating:");
                float rating = scanner.nextFloat();
                scanner.nextLine(); // Clear buffer
                System.out.println("Enter Image Path:");
                String imagePath = scanner.nextLine();

                Restaurant newRestaurant = new Restaurant();
                newRestaurant.setRestaurantId(restaurantId);
                newRestaurant.setRestaurantName(name);
                newRestaurant.setCuisineType(cuisineType);
                newRestaurant.setDeliveryTime(deliveryTime);
                newRestaurant.setAddress(address);
                newRestaurant.setRatings(rating);
                newRestaurant.setActive(true); // Default to active as a boolean
                newRestaurant.setImgPath(imagePath);

                restaurantDao.addRestaurant(newRestaurant);
                System.out.println("Restaurant added successfully!");
                break;

            case 2:
                // Fetch All Restaurants
                List<Restaurant> allRestaurants = restaurantDao.getAllRestaurant();
                if (!allRestaurants.isEmpty()) {
                    allRestaurants.forEach(System.out::println);
                } else {
                    System.out.println("No restaurants found.");
                }
                break;

            case 3:
                // Fetch Restaurant by ID
                System.out.println("Enter Restaurant ID:");
                int fetchId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                Restaurant fetchedRestaurant = restaurantDao.getRestaurant(fetchId);
                if (fetchedRestaurant != null) {
                    System.out.println(fetchedRestaurant);
                } else {
                    System.out.println("Restaurant not found.");
                }
                break;

            case 4:
                // Update Restaurant
                System.out.println("Enter Restaurant ID to Update:");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                Restaurant existingRestaurant = restaurantDao.getRestaurant(updateId);
                if (existingRestaurant != null) {
                    System.out.println("Enter New Restaurant Name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter New Cuisine Type:");
                    String newCuisineType = scanner.nextLine();
                    System.out.println("Enter New Delivery Time (in minutes):");
                    String newDeliveryTime = scanner.nextLine();
                    System.out.println("Enter New Address:");
                    String newAddress = scanner.nextLine();
                    System.out.println("Enter New Rating:");
                    float newRating = scanner.nextFloat();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Enter New Image Path:");
                    String newImagePath = scanner.nextLine();

                    existingRestaurant.setRestaurantName(newName);
                    existingRestaurant.setCuisineType(newCuisineType);
                    existingRestaurant.setDeliveryTime(newDeliveryTime);
                    existingRestaurant.setAddress(newAddress);
                    existingRestaurant.setRatings(newRating);
                    existingRestaurant.setImgPath(newImagePath);

                    restaurantDao.updateMenu(existingRestaurant);
                    System.out.println("Restaurant updated successfully!");
                } else {
                    System.out.println("Restaurant not found.");
                }
                break;

            case 5:
                // Delete Restaurant
                System.out.println("Enter Restaurant ID to Delete:");
                int deleteId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                restaurantDao.deleteMenu(deleteId);
                System.out.println("Restaurant deleted successfully!");
                break;

            case 6:
                // Back to Main Menu
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void manageMenus(Scanner scanner, MenuDaoImpl menuDao) {
        System.out.println("\nMenu Management:");
        System.out.println("1. Add Menu");
        System.out.println("2. Fetch All Menus");
        System.out.println("3. Fetch Menu by ID");
        System.out.println("4. Update Menu");
        System.out.println("5. Delete Menu");
        System.out.println("6. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                // Add Menu
                System.out.println("Enter Restaurant ID:");
                int restaurantId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Menu Name:");
                String menuName = scanner.nextLine();
                System.out.println("Enter Description:");
                String description = scanner.nextLine();
                System.out.println("Enter Price:");
                float price = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Is Available (true/false):");
                boolean isAvailable = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Enter Image Path:");
                String imgPath = scanner.nextLine();

                Menu newMenu = new Menu(restaurantId, menuName, price, description, isAvailable, imgPath);
                int status = menuDao.addMenu(newMenu);
                System.out.println(status > 0 ? "Menu added successfully!" : "Failed to add menu.");
                break;

            case 2:
                // Fetch All Menus
                System.out.println("Enter Restaurant ID (0 for all menus):");
                int fetchRestaurantId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                List<Menu> menus = menuDao.getAllMenu(fetchRestaurantId);
                if (!menus.isEmpty()) {
                    menus.forEach(System.out::println);
                } else {
                    System.out.println("No menus found.");
                }
                break;

            case 3:
                // Fetch Menu by ID
                System.out.println("Enter Menu ID:");
                int menuId = scanner.nextInt();
                scanner.nextLine();
                Menu fetchedMenu = menuDao.getMenu(menuId);
                System.out.println(fetchedMenu != null ? fetchedMenu : "Menu not found.");
                break;

            case 4:
                // Update Menu
                System.out.println("Enter Menu ID:");
                menuId = scanner.nextInt();
                scanner.nextLine();
                Menu menuToUpdate = menuDao.getMenu(menuId);
                if (menuToUpdate != null) {
                    System.out.println("Enter New Menu Name:");
                    menuName = scanner.nextLine();
                    System.out.println("Enter New Description:");
                    description = scanner.nextLine();
                    System.out.println("Enter New Price:");
                    price = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Is Available (true/false):");
                    isAvailable = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.println("Enter New Image Path:");
                    imgPath = scanner.nextLine();

                    menuToUpdate.setMenuName(menuName);
                    menuToUpdate.setDescription(description);
                    menuToUpdate.setPrice(price);
                    menuToUpdate.setAvailable(isAvailable);
                    menuToUpdate.setImgPath(imgPath);

                    status = menuDao.updateMenu(menuToUpdate);
                    System.out.println(status > 0 ? "Menu updated successfully!" : "Failed to update menu.");
                } else {
                    System.out.println("Menu not found.");
                }
                break;

            case 5:
                // Delete Menu
                System.out.println("Enter Menu ID:");
                menuId = scanner.nextInt();
                scanner.nextLine();
                status = menuDao.deleteMenu(menuId);
                System.out.println(status > 0 ? "Menu deleted successfully!" : "Failed to delete menu.");
                break;

            case 6:
                // Back to Main Menu
                return;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
    
    
    private static void manageOrders(Scanner scanner, OrderTableImpl orderTableDAO) {
        System.out.println("\nOrder Management:");
        System.out.println("1. Add Order\n2. Fetch All Orders\n3. Fetch Order by ID\n4. Update Order\n5. Delete Order\n6. Back to Main Menu");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                // Add order logic
                System.out.println("Enter Order ID:");
                int orderId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter User ID:");
                int userId = scanner.nextInt();
                System.out.println("Enter Restaurant ID:");
                int restaurantId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Order Status:");
                String status = scanner.nextLine();
                System.out.println("Enter Payment Mode:");
                String paymentMode = scanner.nextLine();
                System.out.println("Enter Total Amount:");
                float totalAmount = scanner.nextFloat();
                String orderDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

                OrderTable orderTable = new OrderTable(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode);
                int result = orderTableDAO.addOrderTable(orderTable);
                if (result > 0) {
                    System.out.println("Order added successfully!");
                } else {
                    System.out.println("Failed to add order.");
                }
                break;
            case 2:
                // Fetch all orders
                System.out.println("Enter User ID to fetch orders:");
                userId = scanner.nextInt();
                List<OrderTable> orders = orderTableDAO.getAllOrderTable(userId);
                orders.forEach(System.out::println);
                break;
            case 3:
                // Fetch order by ID
                System.out.println("Enter Order ID:");
                orderId = scanner.nextInt();
                OrderTable fetchedOrder = orderTableDAO.getOrderTable(orderId);
                System.out.println(fetchedOrder != null ? fetchedOrder : "Order not found.");
                break;
            case 4:
                // Update order
                System.out.println("Order update logic can be added here.");
                break;
            case 5:
                // Delete order
                System.out.println("Order deletion logic can be added here.");
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void manageOrderItem(Scanner scanner, OrderItemDaoImpl orderItemDao) {
        System.out.println("\nOrder Item Management Options:");
        System.out.println("1. Add Order Item");
        System.out.println("2. View All Order Items by Order ID");
        System.out.println("3. View Order Item by Order Item ID");
        System.out.println("4. Update Order Item");
        System.out.println("5. Delete Order Item");
        System.out.println("6. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        switch (choice) {
            case 1:
                // Add Order Item
                System.out.println("Enter Order ID:");
                int orderId = scanner.nextInt();
                System.out.println("Enter Menu ID:");
                int menuId = scanner.nextInt();
                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();
                System.out.println("Enter SubTotal:");
                float subTotal = scanner.nextFloat();

                OrderItem newOrderItem = new OrderItem();
                newOrderItem.setOrderId(orderId);
                newOrderItem.setMenuId(menuId);
                newOrderItem.setQuantity(quantity);
                newOrderItem.setSubTotal(subTotal);

                int status = orderItemDao.addOrderItem(newOrderItem);
                System.out.println(status > 0 ? "Order Item added successfully!" : "Failed to add Order Item.");
                break;
            case 2:
                // View All Order Items by Order ID
                System.out.println("Enter Order ID:");
                int orderIdForAllItems = scanner.nextInt();
                List<OrderItem> allOrderItems = orderItemDao.getAllOrderItem(orderIdForAllItems);
                if (allOrderItems != null && !allOrderItems.isEmpty()) {
                    allOrderItems.forEach(System.out::println);
                } else {
                    System.out.println("No order items found for this order ID.");
                }
                break;
            case 3:
                // View Order Item by Order Item ID
                System.out.println("Enter Order Item ID:");
                int orderItemId = scanner.nextInt();
                OrderItem fetchedOrderItem = orderItemDao.getOrderItem(orderItemId);
                System.out.println(fetchedOrderItem != null ? fetchedOrderItem : "Order Item not found.");
                break;
            case 4:
                // Update Order Item
                System.out.println("Enter Order Item ID for Update:");
                int orderItemIdToUpdate = scanner.nextInt();
                OrderItem orderItemToUpdate = orderItemDao.getOrderItem(orderItemIdToUpdate);
                if (orderItemToUpdate != null) {
                    System.out.println("Enter New Order ID:");
                    orderId = scanner.nextInt();
                    System.out.println("Enter New Menu ID:");
                    menuId = scanner.nextInt();
                    System.out.println("Enter New Quantity:");
                    quantity = scanner.nextInt();
                    System.out.println("Enter New SubTotal:");
                    subTotal = scanner.nextFloat();

                    orderItemToUpdate.setOrderId(orderId);
                    orderItemToUpdate.setMenuId(menuId);
                    orderItemToUpdate.setQuantity(quantity);
                    orderItemToUpdate.setSubTotal(subTotal);

                    status = orderItemDao.updateOrderItem(orderItemToUpdate);
                    System.out.println(status > 0 ? "Order Item updated successfully!" : "Failed to update Order Item.");
                } else {
                    System.out.println("Order Item not found.");
                }
                break;
            case 5:
                // Delete Order Item
                System.out.println("Enter Order Item ID to Delete:");
                int orderItemIdToDelete = scanner.nextInt();
                status = orderItemDao.deleteOrderItem(orderItemIdToDelete);
                System.out.println(status > 0 ? "Order Item deleted successfully!" : "Failed to delete Order Item.");
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
    
    private static void manageOrderHistory(Scanner scanner, OrderHistoryDaoImpl orderHistoryDao) {
        System.out.println("\nOrder History Management:");
        System.out.println("1. Add Order History");
        System.out.println("2. Fetch All Order Histories");
        System.out.println("3. Fetch Order History by ID");
        System.out.println("4. Update Order History");
        System.out.println("5. Delete Order History");
        System.out.println("6. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                // Add Order History
                System.out.println("Enter Order ID:");
                int orderId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                System.out.println("Enter User ID:");
                int userId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                System.out.println("Enter Total Amount:");
                float totalAmount = scanner.nextFloat();
                scanner.nextLine(); // Clear buffer
                System.out.println("Enter Status:");
                String status = scanner.nextLine();
                
                // Get the current system date
                String orderDate = LocalDate.now().toString(); // Format: yyyy-MM-dd

                OrderHistory newOrderHistory = new OrderHistory(orderId, userId, totalAmount, status, orderDate);
                int status1 = orderHistoryDao.addOrderHistory(newOrderHistory);
                System.out.println(status1 > 0 ? "Order History added successfully!" : "Failed to add Order History.");
                break;

            case 2:
                // Fetch All Order Histories
                System.out.println("Enter User ID to fetch Order History (0 for all):");
                int fetchUserId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                List<OrderHistory> orderHistories = orderHistoryDao.getAllOrderHistory(fetchUserId);
                if (!orderHistories.isEmpty()) {
                    orderHistories.forEach(System.out::println);
                } else {
                    System.out.println("No Order Histories found.");
                }
                break;

            case 3:
                // Fetch Order History by ID
                System.out.println("Enter Order History ID:");
                int orderHistoryId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                OrderHistory fetchedOrderHistory = orderHistoryDao.getOrderHistory(orderHistoryId);
                System.out.println(fetchedOrderHistory != null ? fetchedOrderHistory : "Order History not found.");
                break;

            case 4:
                // Update Order History
                System.out.println("Enter Order History ID:");
                orderHistoryId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                OrderHistory orderHistoryToUpdate = orderHistoryDao.getOrderHistory(orderHistoryId);
                if (orderHistoryToUpdate != null) {
                    System.out.println("Enter New Order ID:");
                    orderId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Enter New User ID:");
                    userId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Enter New Total Amount:");
                    totalAmount = scanner.nextFloat();
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Enter New Status:");
                    status = scanner.nextLine();
                    
                    // Use current system date for update as well
                    orderDate = LocalDate.now().toString(); // Format: yyyy-MM-dd

                    orderHistoryToUpdate.setOrderId(orderId);
                    orderHistoryToUpdate.setUserId(userId);
                    orderHistoryToUpdate.setTotalAmount(totalAmount);
                    orderHistoryToUpdate.setStatus(status);
                    orderHistoryToUpdate.setOrderDate(orderDate);

                    // This will update the order history in the database
                    status1 = orderHistoryDao.addOrderHistory(orderHistoryToUpdate); // Can use update method if implemented in DAO
                    System.out.println(status1 > 0 ? "Order History updated successfully!" : "Failed to update Order History.");
                } else {
                    System.out.println("Order History not found.");
                }
                break;

            case 5:
                // Delete Order History
                System.out.println("Enter Order History ID to Delete:");
                orderHistoryId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                status1 = orderHistoryDao.deleteOrderHistory(orderHistoryId); // Implement delete method in DAO
                System.out.println(status1 > 0 ? "Order History deleted successfully!" : "Failed to delete Order History.");
                break;

            case 6:
                // Back to Main Menu
                return;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

   

}