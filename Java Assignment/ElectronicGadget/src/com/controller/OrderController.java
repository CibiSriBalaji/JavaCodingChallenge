package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDetailsDto;
import com.model.Order;
import com.model.OrderDetails;
import com.service.OrderService;

public class OrderController {
public static void main(String[] args) {
	OrderService orderService = new OrderService();
	Scanner sc = new Scanner(System.in);
	while (true) {
		System.out.println("\n ...Order Menu ....");
		System.out.println("Press 1. Find the Total amount of an order ");
		System.out.println("Press 2. Get Order Details ");
		System.out.println("Press 3. Update Order status ");
		System.out.println("Press 4. Cancel Order ");
		System.out.println("Press 5. Calculate subtotal of a particular order detail ");
		System.out.println("Press 6. Update Quantity of a particular order detail ");
		System.out.println("Press 7. Get All Order Details ");
		System.out.println("Press 0. to Exit");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("Exiting Order Module..");
			break;
		}

		switch (input) {

		case 1:
			try {
				List<OrderDetailsDto> list = orderService.findAll();
				System.out.println("----------------------------------------------------------------------------\n");
				System.out.format("%10s%20s%30s%10s", "Order ID", "Order Date", "Product ID", "Quantity");
				System.out.println("\n---------------------------------------------------------------------------");
				for (OrderDetailsDto order : list) {
					System.out.format("%10d%20s%30d%10d", 
							order.getOrderID(), 
							order.getOrderDate(), 
							order.getProductID(), 
							order.getQuantity());
					    System.out.println();
				}
				System.out.println("\n----------------------------------------------------------------------------\n");
				System.out.println("Enter Order ID");
				System.out.println("The Total Amount of the order is "+ orderService.getTotalAmount(sc.nextInt()));

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {
				List<OrderDetailsDto> list = orderService.findAll();
				System.out.println("----------------------------------------------------------------------------\n");
				System.out.format("%10s%20s%30s%10s", "Order ID", "Order Date", "Product ID", "Quantity");
				System.out.println("\n---------------------------------------------------------------------------");
				for (OrderDetailsDto order : list) {
					System.out.format("%10d%20s%30d%10d", 
							order.getOrderID(), 
							order.getOrderDate(), 
							order.getProductID(), 
							order.getQuantity());
					    System.out.println();
				}
				System.out.println("\n----------------------------------------------------------------------------\n");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println("Update Order Status...");
			try {
				List<Order> list = orderService.findAllOrders();
				System.out.println("------------------------------------------------------------------------------------------\n");
				System.out.format("%10s%20s%30s%20s", "Order ID", "Order Date", "TotalAmount", "OrderStatus");
				System.out.println("\n-----------------------------------------------------------------------------------------");
				for (Order order : list) {
					System.out.format("%10d%20s%30f%20s", 
							order.getOrderID(), 
							order.getOrderDate(), 
							order.getTotalAmount(), 
							order.getOrderStatus());
					    System.out.println();
				}
				System.out.println("\n------------------------------------------------------------------------------------------\n");
				System.out.println("Enter Order ID");
				int OrderID = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter order status (processing/shipped) ");
				int status = orderService.updateOrderStatus(OrderID, sc.nextLine());
				if(status == 1) {
					System.out.println("Status updated...");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Cancel Order...");
			try {
				List<Order> list = orderService.findAllOrders();
				System.out.println("-----------------------------------------------------------------------------------------\n");
				System.out.format("%10s%20s%30s%20s", "Order ID", "Order Date", "TotalAmount", "OrderStatus");
				System.out.println("\n----------------------------------------------------------------------------------------");
				for (Order order : list) {
					System.out.format("%10d%20s%30f%20s", 
							order.getOrderID(), 
							order.getOrderDate(), 
							order.getTotalAmount(), 
							order.getOrderStatus());
					    System.out.println();
				}
				System.out.println("\n-----------------------------------------------------------------------------------------\n");
				System.out.println("Enter Order ID");
				int OrderID = sc.nextInt();
				String status = "cancelled";
				orderService.updateOrderStatus(OrderID, status);
				System.out.println("order cancelled");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Calculate subtotal of a particular order detail...");
			try {
				List<OrderDetails> list = orderService.findAllOrderDetails();
				System.out.println("\n---------------------------------------------------------------------------");
				for (OrderDetails order : list) {
					System.out.println(order);
				}
				System.out.println("\n----------------------------------------------------------------------------\n");
				System.out.println("Enter Order Detail ID");
				System.out.println("The Sub Total of the order detail is "+ orderService.getSubTotalAmount(sc.nextInt()));

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			break;
		case 6:
			System.out.println("Update Quantity of a particular order detail...");
			try {
				List<OrderDetails> list = orderService.findAllOrderDetails();
				System.out.println("\n---------------------------------------------------------------------------");
				for (OrderDetails order : list) {
					System.out.println(order);
				}
				System.out.println("\n----------------------------------------------------------------------------\n");
				System.out.println("Enter Order Detail ID");
				int orderDetailID = sc.nextInt();
				System.out.println("Enter the quantity ");
				int quantity = sc.nextInt();
				int status = orderService.updateOrderQuantity(orderDetailID, quantity);
				if(status == 1) {
					System.out.println("Quantity updated...");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 7:
			System.out.println("Get order detail...");
			try {
				List<OrderDetailsDto> list = orderService.findAll();
				System.out.println("----------------------------------------------------------------------------\n");
				System.out.format("%10s%20s%30s%10s", "Order ID", "Order Date", "Product ID", "Quantity");
				System.out.println("\n---------------------------------------------------------------------------");
				for (OrderDetailsDto order : list) {
					System.out.format("%10d%20s%30d%10d", 
							order.getOrderID(), 
							order.getOrderDate(), 
							order.getProductID(), 
							order.getQuantity());
					    System.out.println();
				}
				System.out.println("\n----------------------------------------------------------------------------\n");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		
		}

	}
}
public static void OrderMenu() {
	String[] sarry = { "" };
	main(sarry);
}
}
