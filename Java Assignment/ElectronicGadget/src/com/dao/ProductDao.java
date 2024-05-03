package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ProductDetailsDto;
import com.exception.ProductNotFoundException;
import com.model.Product;

public interface ProductDao {

	List<Product> findAll() throws SQLException;

	ProductDetailsDto getProductDetails(int productID)  throws SQLException, ProductNotFoundException;

	int updatePrice(int productId, double price) throws SQLException, ProductNotFoundException;

}
