package com.dto;

import com.model.Product;

public class OrderDetailsDto {
	private int OrderID;
	private String OrderDate;
	private double TotalAmount;
	private int ProductID;
	private int Quantity;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetailsDto [OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount
				+ ", ProductID=" + ProductID + ", Quantity=" + Quantity + "]";
	}
	public OrderDetailsDto(int orderID, String orderDate, int productID, int quantity) {
		super();
		OrderID = orderID;
		OrderDate = orderDate;
		ProductID = productID;
		Quantity = quantity;
	}
	public OrderDetailsDto(int orderID, String orderDate, double totalAmount, int productID, int quantity) {
		super();
		OrderID = orderID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		ProductID = productID;
		Quantity = quantity;
	}
	public OrderDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
