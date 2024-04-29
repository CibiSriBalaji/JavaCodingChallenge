package com.model;

public class Order {
private int OrderId;
private int UserId;
private int ProductId;
private int quantity;
private String Status;
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getProductId() {
	return ProductId;
}
public void setProductId(int productId) {
	ProductId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


@Override
public String toString() {
	return "Order [OrderId=" + OrderId + ", UserId=" + UserId + ", ProductId=" + ProductId + ", quantity=" + quantity
			+ ", Status=" + Status + "]";
}


public Order(int orderId, int userId, int productId, int quantity, String status) {
	super();
	OrderId = orderId;
	UserId = userId;
	ProductId = productId;
	this.quantity = quantity;
	Status = status;
}

public Order(int userId, int productId, int quantity, String status) {
	super();
	UserId = userId;
	ProductId = productId;
	this.quantity = quantity;
	Status = status;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}

}
