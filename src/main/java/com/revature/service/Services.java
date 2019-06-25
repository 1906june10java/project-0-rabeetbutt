package com.revature.service;
import com.revature.controller.*;
import com.revature.exception.*;
import com.revature.repository.*;

public class Services {
	//Services(Account)
	//calls exception to validate data
	
	UserDAO repository = new UserRepository();
	CustomException customException = new CustomException();
	
	public boolean validateUName(String uName) throws Exception  {
		
		if (uName.isEmpty()) {
			customException.throwExceptionBlank();
			return false;
		}
		
		/*else if (uName.equals(repository.findUserName(uName))){
			customException.throwExceptionExists();
			return false;
		}*/
		
		else {
			return true;
		}
		
	}
	
	public boolean validatePWord(String uName, String pWord) throws Exception {
		
		if (pWord.isEmpty()) {
			customException.throwExceptionBlank();
			return false;
		}
		
		else if (pWord.equals(repository.findPassword(uName))) {
			System.out.println("Successful login");
			return true;
		}
		else if (repository.findPassword(uName) == null){
			System.out.println("password from input is: " + pWord);
			System.out.println("password from db is: " + repository.findPassword(uName));
			return true;
		}
		else {
			customException.throwExceptionPWord();
			return false;
		}
		
	}
	
	public boolean validateBalance(String uName, Double balance) throws Exception {
		
		if(balance.toString().isEmpty()) {
			customException.throwExceptionBlank();
			return false;
		}
		
		else if (repository.updateBalance(uName, balance) == null) {
			System.out.println("initial balance: " + repository.updateBalance(uName, balance));
			return true;
		}
		
		else if (repository.updateBalance(uName, balance) < 0) {
			customException.throwExceptionWithdraw();
			return false;
		}
				
		else {
			return true;
		}
	}
	
}
