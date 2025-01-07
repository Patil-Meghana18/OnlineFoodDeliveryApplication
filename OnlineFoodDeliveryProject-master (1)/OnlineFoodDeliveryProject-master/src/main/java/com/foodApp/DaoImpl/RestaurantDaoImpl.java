package com.foodApp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.RestaurantDao;
import com.foodApp.modules.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status;
	private List<Restaurant> restaurantList = null;
	
	private static final String ADD_RESTAURANT_QUERY = "insert into restaurant (restaurantName, deliveryTime, cuisineType, address, "
			+ "ratings, isActive, imgPath) values(?,?,?,?,?,?,?)";
	private static final String GET_ALL_RESTAURANT_QUERY = "select * from restaurant";
	private static final String GET_RESTAURANT_QUERY = "select * from restaurant where restaurantId=?";
	private static final String UPDATE_QUERY = "update restaurant set restaurantName=?, deliveryTime=?, cuisineType=?, address=?, "
			+ "ratings=?, isActive=?, imgPath=? where restaurantId=?";
	private static final String DELETE_QUERY = "delete from restaurant where restaurantId=?";
    private static final String GET_RESTAURANTNAME_QUERY = "select restaurantName from restaurant where restaurantId=?";
    private static final String GET_IMAGE_QUERY = "select imgPath from restaurant where restaurantId=?";

	public RestaurantDaoImpl() {
		con = Connect.getConnect();
	}

	@Override
	public int addRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(ADD_RESTAURANT_QUERY);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setString(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setBoolean(6, r.isActive()); // Changed from setString to setBoolean
			pstmt.setString(7, r.getImgPath());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(GET_ALL_RESTAURANT_QUERY);
			restaurantList = new ArrayList<>();
			while (res.next()) {
				int restaurantId = res.getInt("restaurantId");
				String restaurantName = res.getString("restaurantName");
				String deliveryTime = res.getString("deliveryTime");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				float ratings = res.getFloat("ratings");
				boolean isActive = res.getBoolean("isActive"); // Changed from String to boolean
				String imgPath = res.getString("imgPath");
				Restaurant r = new Restaurant(restaurantId, restaurantName, deliveryTime, cuisineType, address, ratings, isActive, imgPath);
				restaurantList.add(r);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Restaurant r = null;
		try {
			pstmt = con.prepareStatement(GET_RESTAURANT_QUERY);
			pstmt.setInt(1, restaurantId);
			res = pstmt.executeQuery();
			if (res.next()) {
				String restaurantName = res.getString("restaurantName");
				String deliveryTime = res.getString("deliveryTime");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				float ratings = res.getFloat("ratings");
				boolean isActive = res.getBoolean("isActive"); // Changed from String to boolean
				String imgPath = res.getString("imgPath");
				r = new Restaurant(restaurantId, restaurantName, deliveryTime, cuisineType, address, ratings, isActive, imgPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int updateMenu(Restaurant r) {
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setString(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setBoolean(6, r.isActive()); // Changed from setString to setBoolean
			pstmt.setString(7, r.getImgPath());
			pstmt.setInt(8, r.getRestaurantId());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMenu(int restaurantId) {
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, restaurantId);
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String restaurantName(int restaurantId) {
		String restaurantName = null;
		try {
			pstmt = con.prepareStatement(GET_RESTAURANTNAME_QUERY);
			pstmt.setInt(1, restaurantId);
			res = pstmt.executeQuery();
			if (res.next()) {
				restaurantName = res.getString("restaurantName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantName;
	}

	/*public byte[] getImage(int restaurantId) {
		byte[] imageBytes = null;
		try {
			pstmt = con.prepareStatement(GET_IMAGE_QUERY);
			pstmt.setInt(1, restaurantId);
			res = pstmt.executeQuery();
			if (res.next()) {
				imageBytes = res.getBytes("imgPath");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imageBytes;
	}*/
}