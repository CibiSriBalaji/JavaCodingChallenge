package com.dto;

public class ProductQuantityDto {
private int ProductID;
private String ProductName;
private int QuantityInStock;




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
public int getQuantityInStock() {
	return QuantityInStock;
}
public void setQuantityInStock(int quantityInStock) {
	QuantityInStock = quantityInStock;
}
@Override
public String toString() {
	return "ProductQuantityDto [ProductID=" + ProductID + ", ProductName=" + ProductName + ", QuantityInStock="
			+ QuantityInStock + "]";
}
public ProductQuantityDto(int productID, String productName, int quantityInStock) {
	super();
	ProductID = productID;
	ProductName = productName;
	QuantityInStock = quantityInStock;
}


}
