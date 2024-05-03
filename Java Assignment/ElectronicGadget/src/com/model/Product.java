package com.model;

public class Product {
	private int ProductID;
	private String ProductName;
	private String Description;
	private double Price;
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", Description=" + Description
				+ ", Price=" + Price + "]";
	}
	public Product(int productID, String productName, String description, double price) {
		super();
		ProductID = productID;
		ProductName = productName;
		Description = description;
		Price = price;
	}

}
