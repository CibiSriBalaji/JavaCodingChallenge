package com.model;

public class Clothing extends Product{
	private String size;
	private String color;
	private int productId;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Clothing(String size,
			String color, int productId) {
		this.size = size;
		this.color = color;
		this.productId = productId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + "]";
	}
	public Clothing(String productName, String description, double price, int quantityInStock, String type, String size,
			String color) {
		super(productName, description, price, quantityInStock, type);
		this.size = size;
		this.color = color;
	}
	public Clothing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clothing(String productName, String description, double price, int quantityInStock, String type) {
		super(productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}

}
