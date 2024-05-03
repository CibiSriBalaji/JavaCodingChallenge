package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.OrderDetailsDto;
import com.dto.ProductQuantityDto;
import com.model.Order;
import com.model.OrderDetails;
import com.model.Product;
import com.utility.DBConnection;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<OrderDetailsDto> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT o.OrderID, o.OrderDate,o.TotalAmount, od.ProductID, od.Quantity "
				+ "FROM orders o "
				+ "INNER JOIN orderdetails od ON o.OrderID = od.OrderID;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<OrderDetailsDto> ordersList = new ArrayList<>();
		while (rst.next()) {
			int orderId = rst.getInt("OrderID");
		    String orderDate = rst.getString("OrderDate");
		    double TotalAmount = rst.getDouble("TotalAmount");
		    int productId = rst.getInt("ProductID");
		    int quantity = rst.getInt("Quantity");

		    OrderDetailsDto order = new OrderDetailsDto(orderId, orderDate,TotalAmount, productId, quantity);

		    ordersList.add(order);
		}
		DBConnection.dbClose();		
		return ordersList;
	}

	@Override
	public double getTotalAmount(int orderID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT SUM(od.Quantity * p.Price) as TotalAmount "
				+ "FROM orderdetails od\n"
				+ "INNER JOIN product p ON od.ProductID = p.ProductID "
				+ "WHERE od.OrderID = ? ;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderID);
		ResultSet rst = pstmt.executeQuery();
		  int TotalAmount = 0; 
		    
		    if (rst.next()) { 
		    	TotalAmount = rst.getInt("TotalAmount");
		    }
		DBConnection.dbClose();		
		return TotalAmount;
	}

	@Override
	public List<Order> findAllOrder() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * from orders ;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Order> ordersList = new ArrayList<>();
		while (rst.next()) {
			int orderId = rst.getInt("OrderID");
			int CustomerID = rst.getInt("CustomerID");
		    String orderDate = rst.getString("OrderDate");
		    double TotalAmount = rst.getDouble("TotalAmount");
		    String OrderStatus = rst.getString("OrderStatus");
		    Order order = new Order(orderId, orderDate, TotalAmount, OrderStatus);

		    ordersList.add(order);
		}
		DBConnection.dbClose();		
		return ordersList;
	}

	@Override
	public int updateOrderStatus(int OrderID, String status) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Orders "
				+ "SET OrderStatus = ?"
				+ "WHERE OrderID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, OrderID);
		int res = pstmt.executeUpdate();
		DBConnection.dbClose();	
		return res;
	}

	@Override
	public List<OrderDetails> findAllOrderDetails() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * from orderdetails;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<OrderDetails> ordersList = new ArrayList<>();
		while (rst.next()) {
			int OrderDetailID = rst.getInt("OrderDetailID");
			int OrderID = rst.getInt("OrderID");
		    int ProductID = rst.getInt("ProductID");
		    int Quantity = rst.getInt("Quantity");
		    
			String sql1="SELECT * from orders where OrderID = ?;";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, OrderID);
			ResultSet rst1 = pstmt1.executeQuery();
		      Order order = null;
		        Product product = null;
			 if (rst1.next()) {
			int orderId = rst1.getInt("OrderID");
			int CustomerID = rst1.getInt("CustomerID");
		    String orderDate = rst1.getString("OrderDate");
		    double TotalAmount = rst1.getDouble("TotalAmount");
		    String OrderStatus = rst1.getString("OrderStatus");
		    order = new Order(orderId, orderDate, TotalAmount, OrderStatus);
			 }
		    String sql2="select * from product where ProductID= ? ";
		    PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, ProductID);
			ResultSet rst2 = pstmt2.executeQuery();
			 if (rst2.next()) {
			int productId = rst2.getInt("ProductID"); 
			    String productName = rst2.getString("ProductName"); 
			    String description = rst2.getString("Description");
			    double price = rst2.getDouble("Price"); 
			    product = new Product(productId, productName, description, price);
			 }
		    OrderDetails orderdetail = new OrderDetails(OrderDetailID, order ,product, Quantity);
		    
		    ordersList.add(orderdetail);
		}
		DBConnection.dbClose();		
		return ordersList;
	}

	@Override
	public double getSubTotalAmount(int orderDetailID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT (od.Quantity * p.Price) AS Subtotal\n"
				+ "FROM \n"
				+ "    OrderDetails od\n"
				+ "JOIN \n"
				+ "    Product p ON od.ProductID = p.ProductID\n"
				+ "WHERE \n"
				+ "    od.OrderDetailID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderDetailID);
		ResultSet rst = pstmt.executeQuery();
		  int Subtotal = 0; 
		    
		    if (rst.next()) { 
		    	Subtotal = rst.getInt("Subtotal");
		    }
		DBConnection.dbClose();		
		return Subtotal;
	}

	@Override
	public int updateOrderQuantity(int orderDetailID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE OrderDetails "
				+ "SET quantity = ? "
				+ "WHERE orderDetailID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, orderDetailID);
		int res = pstmt.executeUpdate();
		DBConnection.dbClose();	
		return res;
	}

	@Override
	public List<ProductQuantityDto> getLowStockProducts() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT p.ProductID, p.ProductName, i.QuantityInStock "
				+ "FROM Product p "
				+ "INNER JOIN Inventory i ON p.ProductID = i.ProductID "
				+ "ORDER BY i.QuantityInStock ASC "
				+ "LIMIT 3;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<ProductQuantityDto> productsList = new ArrayList<>();
		while (rst.next()) {
			int ProductID = rst.getInt("ProductID");
		    String ProductName = rst.getString("ProductName");
			int QuantityInStock = rst.getInt("QuantityInStock");
			ProductQuantityDto product = new ProductQuantityDto(ProductID, ProductName, QuantityInStock);

		    productsList.add(product);
		}
		DBConnection.dbClose();		
		return productsList;
	}

}
