package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.OrderNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Order;
import com.model.Product;
import com.model.User;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserService;

public class UserController {
public static void main(String[] args) {
	ProductService productService = new ProductService();
	UserService userService = new UserService();
	OrderService orderService = new OrderService();
	int UserId = Integer.parseInt(args[0]);
	Scanner sc = new Scanner(System.in);
	while(true) {
		System.out.println("----------User Ops-------------");
		System.out.println("Press 1. Create Order ");
		System.out.println("Press 2. Cancel my order ");
		System.out.println("Press 3. Display my orders ");
		System.out.println("Press 0. to Exit");
		int input = sc.nextInt();
		if(input == 0) {
			System.out.println("Exiting User Module..");
			break; 
		}
		
		switch(input) {
		case 1: 
			try {
				List<Product> list = productService.findAll();
				for(Product p : list) {
					System.out.println(p);
				}
				System.out.println("Enter Product Id: ");
				int productId = sc.nextInt();
				System.out.println("Enter Quantity: ");
				int quantity = sc.nextInt();
				String status ="order placed";
				Order order = new Order(UserId, productId, quantity, status);
				int qstatus = orderService.createOrder(order);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2: 
			try {
				List<Order> orderlist = orderService.findAllByUserId(UserId);
				for(Order o : orderlist) {
					System.out.println(o);
				}
				System.out.println("Enter order number to cancel:");
				int status = orderService.cancelOrder(sc.nextInt());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			break;
		case 3: 
			try {
			  
			    
			    List<Order> orderlist = orderService.findAllByUserId(UserId);
				for(Order o : orderlist) {
					System.out.println(o);
				}
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}				
			break; 
		}
		
	}
}
public static void userMenu(int usrId) {
	String userId = String.valueOf(usrId);
	String[] sarry = {userId};
	main(sarry);
}
}
