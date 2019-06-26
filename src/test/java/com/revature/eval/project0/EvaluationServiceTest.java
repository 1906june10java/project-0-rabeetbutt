package com.revature.eval.project0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.service.Services;
import com.revature.util.ConnectionUtil;



public class EvaluationServiceTest {

	private static final Services evaluationService = new Services();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
/****************************************************************************************************
	Test case 1: User Authentication
****************************************************************************************************/
	
	@Test
	public void successfulLogin() {
		
		String uName = "bfin";
		String pWord = "password3";
		boolean expected = true;
		
		try {
			assertEquals(expected, evaluationService.validatePWord(uName, pWord));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void failedLogin() {
		
		String uName = "bfin";
		String pWord = "passwor";
		boolean expected = false;
		
		try {
			assertEquals(expected, evaluationService.validatePWord(uName, pWord));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
/****************************************************************************************************
	Test case 2: Balance Validation
****************************************************************************************************/
	@Test 
	public void successfulUpdate() {
		String uName = "bfin";
		Double amount = 50D;
		boolean expected = true;
		
		try {
			assertEquals(expected, evaluationService.validateBalance(uName, amount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void unsuccessfulUpdate() {
		String uName = "bfin";
		Double amount = -200D;
		boolean expected = false;
		
		try {
			assertEquals(expected, evaluationService.validateBalance(uName, amount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
