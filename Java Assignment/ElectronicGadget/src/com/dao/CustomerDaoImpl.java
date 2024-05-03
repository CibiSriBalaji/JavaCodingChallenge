package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public int getTotalOrders(int customerID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT COUNT(*) AS TotalOrders "
				+ "FROM Orders "
				+ "WHERE CustomerID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerID);
		ResultSet rst = pstmt.executeQuery();
		  int totalOrders = 0; 
		    
		    if (rst.next()) { 
		        totalOrders = rst.getInt("TotalOrders");
		    }
		DBConnection.dbClose();		
		return totalOrders;
	}

	@Override
	public Customer getCustomerInfo(int customerID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM customer "
				+ "WHERE CustomerID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerID);
		ResultSet rst = pstmt.executeQuery();
		 Customer customer = new Customer();
		    
		    if (rst.next()) { 
		    	customer.setCustomerID(rst.getInt("CustomerID"));
		        customer.setFirstName(rst.getString("FirstName"));
		        customer.setLastName(rst.getString("LastName"));
		        customer.setEmail(rst.getString("Email"));
		        customer.setPhone(rst.getString("Phone"));
		        customer.setAddress(rst.getString("Address"));
		       
		    }
		DBConnection.dbClose();		
		return customer;
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM customer ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List <Customer> customerList = new ArrayList<>();
		    
		    while (rst.next()) { 
		    	Customer customer = new Customer();
		    	customer.setCustomerID(rst.getInt("CustomerID"));
		        customer.setFirstName(rst.getString("FirstName"));
		        customer.setLastName(rst.getString("LastName"));
		        customer.setEmail(rst.getString("Email"));
		        customer.setPhone(rst.getString("Phone"));
		        customer.setAddress(rst.getString("Address"));
		       customerList.add(customer);
		    }
		DBConnection.dbClose();		
		return customerList;
	}

	@Override
	public int updatePhone(int CustomerId, String phone) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Customer "
				+ "SET Phone = ? "
				+ "WHERE CustomerID = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, phone);
		pstmt.setInt(2, CustomerId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();		
		return status;
	}

}
