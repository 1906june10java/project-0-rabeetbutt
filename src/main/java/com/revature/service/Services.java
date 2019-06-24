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
			customException.throwExceptionBlank();
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public boolean validatePWord(String pWord) throws Exception {
		
		if (pWord.equals("")) {
			customException.throwExceptionBlank();
			return false;
		}
		else if (pWord.equals(repository.findPassword(pWord))) {
			return true;
		}
		else {
			customException.throwExceptionPWord();
			return false;
		}
	}
	
	public boolean validateBalance(String uName, Double balance) throws Exception {
		
		if(balance.toString().equals("")) {
			customException.throwExceptionBlank();
			return false;
		}
		else {
			return true;
		}
	}
	
}
