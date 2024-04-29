package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.model.User;
import com.service.UserService;

public class AuthController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();
		while(true) {
			System.out.println("Press 1. User Sign-Up");
			System.out.println("Press 2. Login");
			System.out.println("Press 0. Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Login Module..");
				break; 
			}
			
			switch(input) {
			case 1: 
				User user = new User(); 
				
				System.out.println("Enter name");
				sc.nextLine();
				user.setUsername(sc.nextLine());
				System.out.println("Enter password");
				user.setPassword(sc.nextLine());

				
				/* Assign ROLE */
				user.setRole("User");
				
				
				try {
					userService.createUser(user);
					int status=userService.createUser(user);
					System.out.println("Customer SignUp Success..Please login");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2:
				try {
					
					System.out.println("Enter username");
					sc.nextLine();
					String username = sc.nextLine();
					System.out.println("Enter password");
					String password = sc.nextLine();
					/* go to DB and check if this credentials are valid, if yes then return object*/
					 
					User userObj = userService.login(username,password);
						if(userObj.getRole().equalsIgnoreCase("USER")) {
							//load customer menu
							System.out.println("User Menu");
							UserController.userMenu(userObj.getUserId());
						}
						else {
							System.out.println("--------Admin Menu--------");
							System.out.println("Welcome " + username);
							AdminController.adminMenu();
						}
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (InvalidCredentialsException e) {
					 System.out.println(e.getMessage());
				}
				break; 
			 default: 
				 System.out.println("Invalid input given, try again!!!");
				
		}
		}
		sc.close();
	}

}
