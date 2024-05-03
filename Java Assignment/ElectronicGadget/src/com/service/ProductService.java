package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dto.ProductDetailsDto;
import com.exception.ProductNotFoundException;

public class ProductService {
ProductDao dao = new ProductDaoImpl();
	public List<Product> findAll() throws SQLException{
		return dao.findAll();
	}
	public ProductDetailsDto getProductDetails(int productID) throws SQLException, ProductNotFoundException {	
		return dao.getProductDetails(productID);
	}
	public int updatePrice(int productId, double price) throws SQLException, ProductNotFoundException{
		// TODO Auto-generated method stub
		return dao.updatePrice( productId, price);
	}

}
