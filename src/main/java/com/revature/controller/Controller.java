package com.revature.controller;
import java.util.*;
import com.revature.model.*;
import com.revature.service.*;

//asks and reads user input until one exits the system
public class Controller {
	
	//asks user for first name, last name, user name, password and assigns random account ID
	public static void start() throws Exception {
		
		Scanner userInput = new Scanner(System.in);
		
		//do while
		System.out.println("Please enter your first name: ");
		String firstName = userInput.next();
		
		
		System.out.println("Please enter your last name: ");
		String lastName = userInput.next();
		
		
		//Call services for account details 
		
		Scanner accountInput = new Scanner(System.in);
		Services services = new Services();
		
		//do-while 
		System.out.println("Please enter a user name for the bank account: ");
		String userName = accountInput.next();
		services.validateUName(userName);
		
		System.out.println("Please enter the password for the bank account: ");
		String password = accountInput.next();
		services.validatePWord(password);
		
		System.out.println("Please enter the amount to be deposited: ");
		Double deposit = accountInput.nextDouble();
		services.validateBalance(userName, deposit);
		
	}
	
}
