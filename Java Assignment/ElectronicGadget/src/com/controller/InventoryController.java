package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.ProductDetailsDto;
import com.dto.ProductQuantityDto;
import com.exception.ProductNotFoundException;
import com.model.Inventory;
import com.model.Product;
import com.service.InventoryService;
import com.service.OrderService;
import com.service.ProductService;

public class InventoryController {

	public static void main(String[] args) {
		
		ProductService productService = new ProductService();
		OrderService orderService = new OrderService();
		InventoryService inventoryService = new InventoryService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n ...Inventory Menu ....");
			System.out.println("Press 1. Get Product details from inventory ");
			System.out.println("Press 2. Get Quantity in Stock ");
			System.out.println("Press 3. Add to inventory ");
			System.out.println("Press 4. Remove from inventory ");
			System.out.println("Press 5. Update Quantity of a particular order detail ");
			System.out.println("Press 6. Get the value of Products in Inventory ");
			System.out.println("Press 7. List Low Stock Products ");
			System.out.println("Press 8. Check whether particular quantity of Product available ");
			System.out.println("Press 9. List out of stock products ");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Inventory Module..");
				break;
			}

			switch (input) {
			
			case 1:
				System.out.println("Get Product details from inventory...");
				try {
				List<Inventory> list = inventoryService.findAll();
				System.out.println("\n---------------------------------------------------------------------------");
				for (Inventory inventory : list) {
					System.out.println(inventory);
				}
				System.out.println("\nEnter the product id: ");
				int ProductID = sc.nextInt();
				ProductDetailsDto product = productService.getProductDetails(ProductID);
				System.out.println("PRODUCT ID: " + product.getProductID());
				System.out.println("PRODUCT NAME: " + product.getProductName());
				System.out.println("DESCRIPTION: " + product.getDescription());
				System.out.println("PRICE: " + product.getPrice());
				System.out.println("QUANTITY IN STOCK: " + product.getQuantityInStock());
				System.out.println("LAST STOCK UPDATED: " + product.getLastStockUpdate());
				System.out.println();
				}
				 catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				catch (ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;	
			
			
			case 2:	
				
				System.out.println("Get Quantity in Stock...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.print("\nPRODUCT ID: " + p.getProductID());
						System.out.print(" PRODUCT NAME: " + p.getProductName());
					}
					System.out.println("\nEnter the product id: ");
					System.out.println("Quantity in Stock : "+inventoryService.getQuantityInStock(sc.nextInt()));
					}
					 catch (SQLException e) {
							System.out.println(e.getMessage());
						}
				break;
			case 3:
				System.out.println("Add to inventory...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.print("\nPRODUCT ID: " + p.getProductID());
						System.out.print(" PRODUCT NAME: " + p.getProductName());
					}
					System.out.println("\nEnter Product ID");
					int ProductID = sc.nextInt();
					System.out.println("Enter Quantity to Add");
					int quantity = sc.nextInt();
					int status = inventoryService.addQuantity(ProductID, quantity);
					if(status == 1) {
						System.out.println("Quantity updated...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Remove From inventory...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.print("\nPRODUCT ID: " + p.getProductID());
						System.out.print(" PRODUCT NAME: " + p.getProductName());
					}
					System.out.println("\nEnter Product ID");
					int ProductID = sc.nextInt();
					System.out.println("Enter Quantity to Reduce");
					int quantity = sc.nextInt();
					int status = inventoryService.removeQuantity(ProductID, quantity);
					if(status == 1) {
						System.out.println("Quantity updated...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Update Quantity of a particular order detail...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.print("\nPRODUCT ID: " + p.getProductID());
						System.out.print(" PRODUCT NAME: " + p.getProductName());
					}
					System.out.println("\nEnter Product ID");
					int ProductID = sc.nextInt();
					System.out.println("Enter New Quantity");
					int quantity = sc.nextInt();
					int status = inventoryService.updateQuantity(ProductID, quantity);
					if(status == 1) {
						System.out.println("Quantity updated...");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("value of Products in Inventory...");
				try {
	
					double totalValue = inventoryService.getTotalValue();
					System.out.println("Total Value of Products in Inventory = "+ totalValue);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("Low Stock Products...");
				try {
					List<ProductQuantityDto> list = orderService.getLowStockProducts();
					for (ProductQuantityDto product : list) {
						System.out.println(product);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				System.out.println("Check whether particular quantity of Product available...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.print("\nPRODUCT ID: " + p.getProductID());
						System.out.print(" PRODUCT NAME: " + p.getProductName());
					}
					System.out.println("\nEnter the product id: ");
					int QuantityInStock = inventoryService.getQuantityInStock(sc.nextInt());
					System.out.println("Enter required Quanity: ");
					int RequiredQuantity = sc.nextInt();
					if(QuantityInStock >= RequiredQuantity) {
						System.out.println("Product Available in Inventory ");
					}
					else {
						System.out.println("Product Not Available in Required Quantity ");
					}
					}
					
					 catch (SQLException e) {
							System.out.println(e.getMessage());
						}
				break;
			case 9:
				System.out.println("out of stock products...");
				try {
					List<Product> list = productService.findAll();
					for (Product p : list) {
						int QuantityInStock = inventoryService.getQuantityInStock(p.getProductID());
						if(QuantityInStock < 1) {
							System.out.println(p);
						}
					}
					}
					
					 catch (SQLException e) {
							System.out.println(e.getMessage());
						}
				break;
			}
		}
	}
	public static void InventoryMenu() {
		String[] sarry = { "" };
		main(sarry);
	}	
}
		
	
