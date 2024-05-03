package com.dto;

public class ProductDetailsDto {
	private int ProductID;
	private String ProductName;
	private String Description;
	private double Price;
	private int QuantityInStock;
	private String LastStockUpdate;
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
	public int getQuantityInStock() {
		return QuantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		QuantityInStock = quantityInStock;
	}
	public String getLastStockUpdate() {
		return LastStockUpdate;
	}
	public void setLastStockUpdate(String lastStockUpdate) {
		LastStockUpdate = lastStockUpdate;
	}
	@Override
	public String toString() {
		return "ProductDetailsDto [ProductID=" + ProductID + ", ProductName=" + ProductName + ", Description="
				+ Description + ", Price=" + Price + ", QuantityInStock=" + QuantityInStock + ", LastStockUpdate="
				+ LastStockUpdate + "]";
	}
	public ProductDetailsDto(int productID, String productName, String description, double price, int quantityInStock,
			String lastStockUpdate) {
		super();
		ProductID = productID;
		ProductName = productName;
		Description = description;
		Price = price;
		QuantityInStock = quantityInStock;
		LastStockUpdate = lastStockUpdate;
	}
	public ProductDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
