package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDetailsDto;
import com.dto.ProductQuantityDto;
import com.model.Order;
import com.model.OrderDetails;

public interface OrderDao {

	List<OrderDetailsDto> findAll() throws SQLException;

	double getTotalAmount(int orderID) throws SQLException;

	List<Order> findAllOrder() throws SQLException;

	int updateOrderStatus(int OrderID,String status) throws SQLException;

	List<OrderDetails> findAllOrderDetails()  throws SQLException;

	double getSubTotalAmount(int orderDetailID) throws SQLException;

	int updateOrderQuantity(int orderDetailID, int quantity) throws SQLException;

	List<ProductQuantityDto> getLowStockProducts()  throws SQLException;

}
