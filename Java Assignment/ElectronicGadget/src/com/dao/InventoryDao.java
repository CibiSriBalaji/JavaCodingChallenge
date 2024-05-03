package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Inventory;

public interface InventoryDao {

	List<Inventory> findAll() throws SQLException;

	int getQuantityInStock(int productID) throws SQLException;

	int addQuantity(int productID, int quantity)  throws SQLException;

	int removeQuantity(int productID, int quantity) throws SQLException;

	int updateQuantity(int productID, int quantity) throws SQLException;

	double getTotalValue()  throws SQLException;;

}
