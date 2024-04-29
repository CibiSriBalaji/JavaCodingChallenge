package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Clothing;
import com.model.Electronics;
import com.model.Product;
import com.dao.OrderManagementRepository;
import com.dao.OrderManagementRepositoryImpl;
public class ProductService {
	OrderManagementRepository dao = new OrderManagementRepositoryImpl();
	public int addProduct(Product product) throws SQLException {
		
		return dao.addProduct(product);
	}
	public int addClothing(Clothing clothing) throws SQLException{
		return dao.addClothing(clothing);
		
	}
	public int addElctronics(Electronics electronics) throws SQLException{
		return dao.addElectronics(electronics);
		
	}
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
