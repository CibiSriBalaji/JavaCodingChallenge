package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Order;
import com.dao.OrderManagementRepository;
import com.dao.OrderManagementRepositoryImpl;
import com.exception.OrderNotFoundException;
import com.exception.UserNotFoundException;
public class OrderService {
	OrderManagementRepository dao = new OrderManagementRepositoryImpl();
	
	public List<Order> findAllByUserId(int UserId) throws SQLException, UserNotFoundException{
		return dao.findAllByUserId(UserId);
	}

	public int createOrder(Order order) throws SQLException{
		return dao.createOrder(order);
	}

	public int cancelOrder(int orderId)throws SQLException,OrderNotFoundException {
		return dao.cancelOrder(orderId);
	}

}
