package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.ProductDetailsDto;
import com.exception.ProductNotFoundException;
import com.model.Product;

import com.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		ProductService productService = new ProductService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n ...Product Menu ....");
			System.out.println("Press 1. Get Product Details ");
			System.out.println("Press 2. Update Product Price ");
			System.out.println("Press 3. Check whether the Product in Stock ");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Product Module..");
				break;
			}

			switch (input) {
			case 1:
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.println("PRODUCT ID: " + p.getProductID());
						System.out.println("PRODUCT NAME: " + p.getProductName());
					}

					System.out.println("Enter the product id: ");
					int ProductID = sc.nextInt();
					ProductDetailsDto product = productService.getProductDetails(ProductID);
					System.out.println("PRODUCT ID: " + product.getProductID());
					System.out.println("PRODUCT NAME: " + product.getProductName());
					System.out.println("DESCRIPTION: " + product.getDescription());
					System.out.println("PRICE: " + product.getPrice());
					System.out.println("QUANTITY IN STOCK: " + product.getQuantityInStock());
					System.out.println("LAST STOCK UPDATED: " + product.getLastStockUpdate());
					System.out.println();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				catch (ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Update Product Price...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.println(p);
					}
					System.out.println("Enter the Product id: ");
					int ProductId = sc.nextInt();
					System.out.println("Enter Product price: ");
					int status = productService.updatePrice(ProductId, sc.nextDouble());
					if(status == 1) {
						System.out.println("Price updated...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				catch (ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.println("PRODUCT ID: " + p.getProductID());
						System.out.println("PRODUCT NAME: " + p.getProductName());
					}

					System.out.println("Enter the product id: ");
					int ProductID = sc.nextInt();
					ProductDetailsDto product = productService.getProductDetails(ProductID);
					int quantityInStock = product.getQuantityInStock();
					if (quantityInStock > 0) {
						System.out.println(
								"Yes, The product is currently in Stock \nQUANTITY IN STOCK: " + quantityInStock);
						System.out.println("LAST STOCK UPDATED: " + product.getLastStockUpdate());
					} else {
						System.out.println("Sorry, The product is currently out of Stock");
						System.out.println("LAST STOCK UPDATED: " + product.getLastStockUpdate());
					}

					System.out.println();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				catch (ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			}

		}
	}
	public static void ProductMenu() {
		String[] sarry = { "" };
		main(sarry);
	}
}
