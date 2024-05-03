package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;;
public class CustomerService {
	
CustomerDao dao = new CustomerDaoImpl();

	public int getTotalOrders(int customerID) throws SQLException{
		return dao.getTotalOrders(customerID);
	}

	public Customer getCustomerInfo(int customerID) throws SQLException{
		return dao.getCustomerInfo(customerID);
	}
	public List<Customer> findAll() throws SQLException{
		return dao.findAll();
	}

	public int updatePhone(int CustomerId, String phone)  throws SQLException{
		return dao.updatePhone(CustomerId, phone);
	}
}
