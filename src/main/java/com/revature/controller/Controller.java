package com.revature.controller;
import java.util.*;
import com.revature.model.*;
import com.revature.repository.UserDAO;
import com.revature.repository.UserRepository;
import com.revature.service.*;

//asks and reads user input until one exits the system
public class Controller {
	
	//asks user for first name, last name, user name, password and assigns random account ID
	public static void start() throws Exception {
		
		String userName;
		String password;
		Double deposit;
		
		
		Scanner userInput = new Scanner(System.in);
		
		UserDAO repository = new UserRepository();
		
		//do while
		System.out.println("Please enter your first name: ");
		String firstName = userInput.next();
		
		
		System.out.println("Please enter your last name: ");
		String lastName = userInput.next();
		
		
		//Call services for account details 
		
		Scanner accountInput = new Scanner(System.in);
		Services services = new Services();
		
		//do-while 
		do {
			System.out.println("Please enter a user name for the bank account: ");
			userName = accountInput.next();
		}
		while(!services.validateUName(userName));
		
		
		
		do {
			System.out.println("Please enter the password for the bank account: ");
			password = accountInput.next();
		}
		while(!services.validatePWord(userName, password));
		
		
		
		do {
			System.out.println("Please enter the amount to be deposited (+ value) / withdrawn (- value): ");
			deposit = accountInput.nextDouble();
		}
		while(!services.validateBalance(userName, deposit));
		
		
		
		Account account = new Account(userName, password, deposit);
		User user = new User(firstName, lastName, account);
		
		repository.create(user);
		
		
	}
	
}
