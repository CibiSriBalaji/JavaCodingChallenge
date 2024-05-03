package com.model;

public class OrderDetails {

	private int OrderDetailID;
	private Order Order;
	private Product Product;
	private int Quantity;
	public int getOrderDetailID() {
		return OrderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		OrderDetailID = orderDetailID;
	}
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [OrderDetailID=" + OrderDetailID + ", Order=" + Order.getOrderID() + ", Product=" + Product.getProductID()
				+ ", Quantity=" + Quantity + "]";
	}
	public OrderDetails(int orderDetailID, com.model.Order order, com.model.Product product, int quantity) {
		super();
		OrderDetailID = orderDetailID;
		Order = order;
		Product = product;
		Quantity = quantity;
	}
	
}
