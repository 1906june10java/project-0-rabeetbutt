package com.revature.exception;

//checks for possible invalid user input
public class CustomException {
	
	public void throwExceptionInvalidData() throws Exception {
		throw new Exception("Re-enter info");
	}
	
	public void throwExceptionExists() throws Exception {
		throw new Exception("Username already exists");
	}
	
	public void throwExceptionPWord() throws Exception {
		throw new Exception("Password is incorrect");
	}
	
	public void throwExceptionWithdraw() throws Exception {
		throw new Exception("Not enough money");
	}
	
	
}
