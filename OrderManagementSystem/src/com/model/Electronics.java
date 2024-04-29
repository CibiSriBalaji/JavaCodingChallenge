package com.model;

public class Electronics extends Product{
	private String brand;
	private int warrantyPeriod;
	private int productId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	@Override
	public String toString() {
		return "Electronics [brand=" + brand + ", warrantyPeriod=" + warrantyPeriod + ", productId=" + productId + "]";
	}
	
	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Electronics(String productName, String description, double price, int quantityInStock, String type) {
		super(productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}
	public Electronics(
			String brand, int warrantyPeriod, int productId) {
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
		this.productId = productId;
	}
	

}
