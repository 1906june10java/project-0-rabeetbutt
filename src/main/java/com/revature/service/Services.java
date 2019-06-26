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
		
		if (uName.equals("")) {
			customException.throwExceptionInvalidData();
			return false;
		}
		
		//handles nullpoint exception err
		else if (repository.findUserName(uName) == null) {
			return true;
		}
		
		else if (uName.equals(repository.findUserName(uName))){
			customException.throwExceptionExists();
			return false;
		}
		
		else if (repository.findUserName(uName).equals(uName)) {
			customException.throwExceptionExists();
			return false;
		}
		
		else {
			return true;
		}
		
	}
	
	public boolean validatePWord(String uName, String pWord) throws Exception {
		
		if (pWord.equals("")) {
			customException.throwExceptionInvalidData();
			return false;
		}
		
		else if (pWord.equals(repository.findPassword(uName))) {
			System.out.println("Login successful");
			return true;
		}
		else {
			customException.throwExceptionPWord();
			return false;
		}
		
	}
	
	public boolean validateBalance(String uName, Double amount) throws Exception {
		
		if(amount.toString().isEmpty()) {
			customException.throwExceptionInvalidData();
			return false;
		}
		
		else if (repository.getBalance(uName) == null) {
			return true;
		}
		
		//ensures excess amount of money can never be withdrawn
		else if (repository.getBalance(uName) + amount < 0) {
			customException.throwExceptionWithdraw();
			return false;
		}
				
		else {
			repository.updateBalance(uName, repository.getBalance(uName) + amount);
			return true;
		}
	}
	
}
