package com.model;

public class Order {
	private int OrderID;
	private Customer Customer;
	private String OrderDate;
	private double TotalAmount;
	private String OrderStatus;
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
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
	
	
	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", Customer=" + Customer + ", OrderDate=" + OrderDate + ", TotalAmount="
				+ TotalAmount + ", OrderStatus=" + OrderStatus + "]";
	}
	public Order(int orderID, com.model.Customer customer, String orderDate, double totalAmount) {
		super();
		OrderID = orderID;
		Customer = customer;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
	}
	public Order(com.model.Customer customer, String orderDate, double totalAmount, String orderStatus) {
		super();
		Customer = customer;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		OrderStatus = orderStatus;
	}
	public Order(int orderID,String orderDate, double totalAmount, String orderStatus) {
		super();
		OrderID = orderID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		OrderStatus = orderStatus;
	}
	
	
}
