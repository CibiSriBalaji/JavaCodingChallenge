package com.model;

public class Inventory {
	
	private int InventoryID;
	private Product Product;
	private int QuantityInStock;
	private String LastStockUpdate;
	public int getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
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
		return "Inventory [InventoryID=" + InventoryID + ", Product=" + Product + ", QuantityInStock=" + QuantityInStock
				+ ", LastStockUpdate=" + LastStockUpdate + "]";
	}
	public Inventory(int inventoryID, com.model.Product product, int quantityInStock, String lastStockUpdate) {
		super();
		InventoryID = inventoryID;
		Product = product;
		QuantityInStock = quantityInStock;
		LastStockUpdate = lastStockUpdate;
	}
	
}
