package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDaoImpl;
import com.model.Inventory;
import com.dao.InventoryDao;
public class InventoryService {
InventoryDao dao = new InventoryDaoImpl();
	public List<Inventory> findAll() throws SQLException{
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public int getQuantityInStock(int productID)  throws SQLException{
		// TODO Auto-generated method stub
		return dao.getQuantityInStock(productID);
	}
	public int addQuantity(int productID, int quantity) throws SQLException{
		// TODO Auto-generated method stub
		return dao.addQuantity(productID, quantity);
	}
	public int removeQuantity(int productID, int quantity) throws SQLException{
		// TODO Auto-generated method stub
		return dao.removeQuantity(productID, quantity) ;
	}
	public int updateQuantity(int productID, int quantity)  throws SQLException{
		// TODO Auto-generated method stub
		return dao.updateQuantity(productID, quantity);
	}
	public double getTotalValue() throws SQLException{
		// TODO Auto-generated method stub
		return dao.getTotalValue();
	}

}
