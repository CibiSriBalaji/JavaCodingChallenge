package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.OrderNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Clothing;
import com.model.Electronics;
import com.model.Order;
import com.model.Product;
import com.utility.DBConnection;

public class OrderManagementRepositoryImpl implements OrderManagementRepository{

	@Override
	public int addProduct(Product product) throws SQLException {
		Connection con = DBConnection.dbConnect();
		 String sql = "INSERT INTO product (productName, description, price, quantityInStock, type) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, product.getProductName());
      pstmt.setString(2, product.getDescription());
      pstmt.setDouble(3, product.getPrice());
      pstmt.setInt(4, product.getQuantityInStock());
      pstmt.setString(5, product.getType());
       int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;	
		
	}
	@Override
	public int addElectronics(Electronics electronics) throws SQLException {
		Connection con = DBConnection.dbConnect();
		 String sql = "INSERT INTO Electronics (brand, warrantyPeriod, product_id) "
                 + "VALUES (?, ?, ?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, electronics.getBrand());
      pstmt.setInt(2, electronics.getWarrantyPeriod());
      pstmt.setInt(3, electronics.getProductId());
       int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;	
		
	}

	@Override
	public int addClothing(Clothing clothing) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO Clothing (size, color, product_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
        pstmt.setString(1, clothing.getSize());
        pstmt.setString(2, clothing.getColor());
        pstmt.setInt(3, clothing.getProductId());
		//execute the query 
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		return status;	
		
	}

	@Override
	public List<Product> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from product";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Product> productList = new ArrayList<>();
		while(rst.next() == true) {
			int productId = rst.getInt("id");
	        String productName = rst.getString("productName");
	        String description = rst.getString("description");
	        double price = rst.getDouble("price");
	        int quantityInStock = rst.getInt("quantityInStock");
	        String type = rst.getString("type");
	        Product product = new Product(productId, productName, description, price, quantityInStock, type);
	        productList.add(product);
		}
		DBConnection.dbClose();		
		return productList;
	}

	@Override
	public List<Order> findAllByUserId(int userId) throws SQLException,UserNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from orders WHERE User_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rst = pstmt.executeQuery();
		List<Order> orderList = new ArrayList<>();
		while(rst.next() == true) {
			int orderId = rst.getInt("id");
            int productId = rst.getInt("Product_id");
            int quantity = rst.getInt("quantity");
            String status = rst.getString("status");
            Order order = new Order(orderId, userId, productId, quantity,status);
            orderList.add(order);
		}
		DBConnection.dbClose();		
		return orderList;
	}

	@Override
	public int createOrder(Order order) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO orders (User_id, Product_id, quantity, status) "
                + "VALUES (?, ?, ?, ?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, order.getUserId());
        pstmt.setInt(2, order.getProductId());
        pstmt.setInt(3, order.getQuantity());
        pstmt.setString(4, order.getStatus());
		//execute the query 
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;	
		
	}

	@Override
	public int cancelOrder(int orderId) throws SQLException, OrderNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orders SET status = 'cancelled' WHERE id = ?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, orderId);
		//execute the query 
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
