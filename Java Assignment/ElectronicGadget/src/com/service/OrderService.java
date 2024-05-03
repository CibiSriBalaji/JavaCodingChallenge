package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDetailsDto;
import com.dto.ProductQuantityDto;
import com.model.Order;
import com.model.OrderDetails;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
public class OrderService {
OrderDao dao = new OrderDaoImpl();
	public List<OrderDetailsDto> findAll() throws SQLException{
		return dao.findAll();
	}
	public double getTotalAmount(int OrderID) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getTotalAmount(OrderID);
	}
	public List<Order> findAllOrders() throws SQLException{
		// TODO Auto-generated method stub
		return dao.findAllOrder();
	}
	public int updateOrderStatus(int OrderID, String status) throws SQLException{
		// TODO Auto-generated method stub
		return dao.updateOrderStatus(OrderID, status);
	}
	public List<OrderDetails> findAllOrderDetails() throws SQLException{
		return dao.findAllOrderDetails();
	}
	public double getSubTotalAmount(int orderDetailID) throws SQLException{
		// TODO Auto-generated method stub
		return dao.getSubTotalAmount(orderDetailID);
	}
	public int updateOrderQuantity(int orderDetailID, int quantity)  throws SQLException{
		// TODO Auto-generated method stub
		return dao.updateOrderQuantity(orderDetailID, quantity);
	}
	public List<ProductQuantityDto> getLowStockProducts() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getLowStockProducts();
	}

}
