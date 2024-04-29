package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.OrderNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Clothing;
import com.model.Electronics;
import com.model.Order;
import com.model.Product;

public interface OrderManagementRepository {

	int addProduct(Product product) throws SQLException;

	List<Product> findAll() throws SQLException;

	List<Order> findAllByUserId(int userId) throws SQLException,UserNotFoundException;

	int createOrder(Order order) throws SQLException;

	int cancelOrder(int orderId) throws SQLException, OrderNotFoundException;

	int addElectronics(Electronics electronics) throws SQLException;
	int addClothing(Clothing clothing) throws SQLException;

}
