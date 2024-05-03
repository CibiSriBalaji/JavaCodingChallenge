package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ProductDetailsDto;
import com.exception.ProductNotFoundException;
import com.model.Product;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from product";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Product> productList = new ArrayList<>();
		while (rst.next()) {
		    int productId = rst.getInt("ProductID"); 
		    String productName = rst.getString("ProductName"); 
		    String description = rst.getString("Description");
		    double price = rst.getDouble("Price"); 
		    Product product = new Product(productId, productName, description, price);
		    productList.add(product);
		}
		DBConnection.dbClose();		
		return productList;
	}

	@Override
	public ProductDetailsDto getProductDetails(int productID) throws SQLException, ProductNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT p.*, i.QuantityInStock, i.LastStockUpdate "
				+ "FROM Product p "
				+ "JOIN Inventory i ON p.ProductID = i.ProductID "
				+ "WHERE p.ProductID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productID);
		ResultSet rst = pstmt.executeQuery();
		ProductDetailsDto product = new ProductDetailsDto();
		if (rst.next()) {
			product.setProductID(rst.getInt("ProductID"));
			product.setProductName(rst.getString("ProductName"));
			product.setDescription(rst.getString("Description"));
			product.setPrice(rst.getDouble("Price"));
			product.setQuantityInStock(rst.getInt("QuantityInStock"));
			product.setLastStockUpdate(rst.getString("LastStockUpdate"));
		}
		DBConnection.dbClose();		
		return product;
	}

	@Override
	public int updatePrice(int productId, double price) throws SQLException, ProductNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Product "
				+ "SET Price = ? "
				+ "WHERE ProductID = ?; ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, price);
		pstmt.setInt(2, productId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();		
		return status;
	}

}
