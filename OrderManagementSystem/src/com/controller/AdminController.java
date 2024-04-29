package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.UserNotFoundException;
import com.model.Clothing;
import com.model.Electronics;
import com.model.Order;
import com.model.Product;
import com.model.User;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserService;


public class AdminController {

	public static void main(String[] args) {
		ProductService productService = new ProductService();
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----------Admin Ops-------------");
			System.out.println("Press 1. Create Product ");
			System.out.println("Press 2. Display All Products ");
			System.out.println("Press 3. Display Orders of a User ");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Admin Module..");
				break; 
			}
			
			switch(input) {
			case 1: 
				System.out.println("Enter Product Id");
				int productId = sc.nextInt();
				System.out.println("Enter Product Name");
				sc.nextLine();
				String productName = sc.nextLine();   
				System.out.println("Enter Description");
				String description=sc.nextLine(); 
				System.out.println("Enter Price");
				double price=sc.nextDouble();
				System.out.println("Enter Quantity in Stock");
				int quantityInStock=sc.nextInt();
				System.out.println("Enter Product Type(Clothing/Electronics):");
				sc.nextLine();
				String type = sc.nextLine();  
				
				try {
					if(type.toLowerCase()=="electronics") {
						System.out.println("Enter Product Brand");
						String brand = sc.nextLine();
						System.out.println("Enter Product Warranty Period");
						int warrantyPeriod = sc.nextInt();
						Product product = new Product(productName, description, price, quantityInStock, type);
						
		                productService.addProduct(product);
		                Electronics electronics = new Electronics(brand, warrantyPeriod, productId);
					}else if (type.equalsIgnoreCase("Clothing")) {
		                System.out.println("Enter Clothing Size");
		                String size = sc.nextLine();
		                
		                System.out.println("Enter Clothing Color");
		                String color = sc.nextLine();
		                Product product = new Product(productName, description, price, quantityInStock, type);
		                Clothing clothing = new Clothing(size, color, productId);
		                int status = productService.addClothing(clothing);
		            } else {
		                System.out.println("Invalid product type. Please enter either Clothing or Electronics.");
		            }
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break; 
			case 2: 
				try {
					List<Product> list = productService.findAll();
					for(Product p : list) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: 
				try {
				    List<User> userList = userService.findAll();
				    System.out.println("------------------------------------------\n");
				    System.out.format("%10s%30s", "User ID", "Username");
				    System.out.println("\n-----------------------------------------");
				    for (User user : userList) {
				        System.out.format("%10d%30s", user.getUserId(), user.getUsername());
				        System.out.println();
				    }
				    System.out.println("-------------------------------------------");
				    System.out.println("Enter User ID");
				    
				    List<Order> orderlist = orderService.findAllByUserId(sc.nextInt());
					for(Order o : orderlist) {
						System.out.println(o);
					}
				}catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}				
				break; 
			}
			
		}

	}
	public static void adminMenu() {
		String[] sarry = {""};
		main(sarry);
	}
}
