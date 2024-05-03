package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDetailsDto;
import com.dto.ProductDetailsDto;
import com.dto.ProductQuantityDto;
import com.model.Customer;
import com.model.Inventory;
import com.model.Order;
import com.model.OrderDetails;
import com.model.Product;
import com.service.CustomerService;
import com.service.InventoryService;
import com.service.OrderService;
import com.service.ProductService;

public class CustomerController {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n ...Customer Menu ....");
			System.out.println("Press 1. Calculate Total Orders ");
			System.out.println("Press 2. Get Customer Details ");
			System.out.println("Press 3. Update Customer Phone Number ");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Customer Module..");
				break;
			}

			switch (input) {
			case 1:
				try {
					List <Customer> customerlist = customerService.findAll();
					for(Customer customer: customerlist) {
						System.out.println(customer);
					}
					System.out.println("Enter Customer ID");
					int totalOrders = customerService.getTotalOrders(sc.nextInt());
					System.out.println("The Cutomer has made " + totalOrders + " order(s)");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List <Customer> customerlist = customerService.findAll();
					for(Customer customer: customerlist) {
						System.out.println("ID: "+ customer.getCustomerID()+" Name: "+customer.getFirstName()+" "+customer.getLastName());
					}
					System.out.println("Enter Customer ID");
					Customer customer = customerService.getCustomerInfo(sc.nextInt());
					System.out.println("CUSTOMER ID: " + customer.getCustomerID());
					System.out.println("FIRST NAME: " + customer.getFirstName());
					System.out.println("LAST NAME: " + customer.getLastName());
					System.out.println("EMAIL: " + customer.getEmail());
					System.out.println("PHONE NUMBER: " + customer.getPhone());
					System.out.println("ADDRESS: " + customer.getAddress());

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.out.println("Update Customer Phone Number...");
				try {
					List <Customer> customerlist = customerService.findAll();
					for(Customer customer: customerlist) {
						System.out.println(customer);
					}
					System.out.println("Enter the Customer id: ");
					int CustomerId = sc.nextInt();
					System.out.println("Enter phone number: ");
					sc.nextLine();
					int status = customerService.updatePhone(CustomerId, sc.nextLine());
					if(status == 1) {
						System.out.println("Phone number updated...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			}

		}
	}

	public static void CustomerMenu() {
		String[] sarry = { "" };
		main(sarry);
	}

}
