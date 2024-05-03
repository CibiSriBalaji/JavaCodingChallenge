package com.controller;


import java.util.Scanner;



public class MainController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n ... Menu ....");
			System.out.println("Press 1. Customer Menu ");
			System.out.println("Press 2. Product Menu ");
			System.out.println("Press 3. Order Menu ");
			System.out.println("Press 4. Inventory Menu ");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting User Module..");
				break;
			}

			switch (input) {
			case 1:
				CustomerController.CustomerMenu();
				break;
			case 2:
				ProductController.ProductMenu();
				break;
			case 3:
				OrderController.OrderMenu();
				break;
			case 4:
				InventoryController.InventoryMenu();
				break;
			}
		}
	}

}
