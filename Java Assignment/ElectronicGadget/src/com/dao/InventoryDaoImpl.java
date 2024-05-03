package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Inventory;
import com.model.Product;
import com.utility.DBConnection;

public class InventoryDaoImpl implements InventoryDao{

	@Override
	public List<Inventory> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="Select * from inventory;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Inventory> inventoryList = new ArrayList<>();
		while (rst.next()) {
			int orderId = rst.getInt("InventoryID");
			int ProductID = rst.getInt("ProductID");
			int QuantityInStock = rst.getInt("QuantityInStock");
		    String LastStockUpdate = rst.getString("LastStockUpdate");
		    Product product = null;
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
		    Inventory inv = new Inventory(orderId, product, QuantityInStock, LastStockUpdate);

		    inventoryList.add(inv);
		}
		DBConnection.dbClose();		
		return inventoryList;
	}

	@Override
	public int getQuantityInStock(int productID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT QuantityInStock FROM Inventory WHERE ProductID = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productID);
		ResultSet rst = pstmt.executeQuery();
		  int QuantityInStock = 0; 
		    
		    if (rst.next()) { 
		    	QuantityInStock = rst.getInt("QuantityInStock");
		    }
		DBConnection.dbClose();		
		return QuantityInStock;
	}

	@Override
	public int addQuantity(int productID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Inventory "
				+ "SET QuantityInStock = QuantityInStock + ? "
				+ "WHERE ProductID = ?; ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, productID);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();	
		return status;
	}

	@Override
	public int removeQuantity(int productID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Inventory "
				+ "SET QuantityInStock = QuantityInStock - ? "
				+ "WHERE ProductID = ?; ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, productID);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();	
		return status;
	}

	@Override
	public int updateQuantity(int productID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Inventory "
				+ "SET QuantityInStock = ? "
				+ "WHERE ProductID = ?; ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, productID);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();	
		return status;
	}

	@Override
	public double getTotalValue() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT SUM(p.Price * i.QuantityInStock) AS TotalValue "
				+ "FROM Product p "
				+ "INNER JOIN Inventory i ON p.ProductID = i.ProductID; ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		double TotalValue = 0; 
		    
		    if (rst.next()) { 
		    	TotalValue = rst.getDouble("TotalValue");
		    }
		DBConnection.dbClose();		
		return TotalValue;
	}
	}

