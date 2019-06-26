package com.revature.controller;
import java.util.*;

import com.revature.exception.CustomException;
import com.revature.model.*;
import com.revature.repository.UserDAO;
import com.revature.repository.UserRepository;
import com.revature.service.*;

//asks and reads user input until one exits the system
public class Controller {
	
	public static void menu() {
		System.out.println("Welcome to Rabeet's Online Bank");
		System.out.println("	Press 1 to create user");
		System.out.println("	Press 2 to login");
		System.out.println("	Press 3 to logout");
	}
	
	//asks user for first name, last name, user name, password and assigns random account ID
	public static void start() throws Exception {
		
		String userName;
		String password;
		Double amount = 0D;	
		Scanner userInput = new Scanner(System.in);
		UserDAO repository = new UserRepository();
		Services services = new Services();
		CustomException cException = new CustomException();
		
		//iterates over a menu 
		boolean quit = false;
		do {
			
			menu();
			int option = userInput.nextInt();
			switch(option) {
			//create user account
			case 1:
				
				System.out.println("Please enter your first name: ");
				String firstName = userInput.next();
				
				System.out.println("Please enter your last name: ");
				String lastName = userInput.next();
				
				
				do {
					System.out.println("Please enter a user name for the bank account: ");
					userName = userInput.next();
				}while(!services.validateUName(userName));
				
				
				System.out.println("Please enter the password for the bank account: ");
				password = userInput.next();
				
				do {
					try {
					System.out.println("Please enter the amount to be initially deposited: ");
					amount = userInput.nextDouble();
					}
					catch (Exception e) {
						cException.throwExceptionInvalidData();
					}
					continue;
				}while(amount < 0);
				
				Account account = new Account(userName, password, amount);
				User user = new User(firstName, lastName, account);
				repository.create(user);
				
				System.out.println("View current balance: " + "$" + repository.getBalance(userName));
				
				break;
				
			//login into existing account
			case 2:
				
				System.out.println("Please enter a user name for the bank account: ");
				userName = userInput.next();
				
				do {
					System.out.println("Please enter the password for the bank account: ");
					password = userInput.next();
				}while(!services.validatePWord(userName, password));
				
				
				do {
					System.out.println("Please enter the amount to be deposited (+ value) / withdrawn (- value): ");
					amount = userInput.nextDouble();
				}while(!services.validateBalance(userName, amount));
				
				
				System.out.println("View current balance: " + "$" + repository.getBalance(userName));
				
				break;
				
			//logout
			case 3:
				System.out.println("Logout successful");
				quit = true;

			}
			
		}while(!quit);
		
		
	}
}
