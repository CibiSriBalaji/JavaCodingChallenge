package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	int getTotalOrders(int customerID) throws SQLException;

	Customer getCustomerInfo(int customerID) throws SQLException;

	List<Customer> findAll() throws SQLException;

	int updatePhone(int CustomerId, String phone)  throws SQLException;

}
