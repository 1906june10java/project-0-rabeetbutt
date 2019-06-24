package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.model.Account;

import com.revature.util.ConnectionUtil;

public class UserRepository implements UserDAO{

	private static final Logger LOGGER = Logger.getLogger(UserRepository.class);
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean create(User user) {
		LOGGER.trace("Entering create method with parameter: " + user);
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			int parameterIndex = 0;
			String sql = "INSERT INTO USER_ACCOUNT VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++parameterIndex, user.getFirstName());	
			statement.setString(++parameterIndex, user.getLastName());
			statement.setString(++parameterIndex, user.getAccount().getUserName());
			statement.setString(++parameterIndex, user.getAccount().getPassword());
			statement.setDouble(++parameterIndex, user.getAccount().getBalance());
			
			if (statement.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not create user account.", e);
		}
		
		return false;
	}
	
	@Override
	public String findUserName(String userName) {
		
		LOGGER.trace("Entering find user name by name method with paramter: " + userName);
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			int paramterIndex = 0;
			String sql = "SELECT U_NAME FROM USER_ACCOUNT WHERE U_NAME = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++paramterIndex, userName);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return result.getString("U_NAME");
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not find user name", e);
		}
		return null;
	}
	
	

	@Override
	public String findPassword(String userName) {
		
		LOGGER.trace("Entering find password by name method with username: " + userName);
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			int paramterIndex = 0;
			String sql = "SELECT P_WORD FROM USER_ACCOUNT WHERE U_NAME = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++paramterIndex, userName);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return result.getString("P_WORD");
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not find password", e);
		}
		return null;
	}
	
	

	@Override
	public Double updateBalance(String userName, Double amount) {
		
		LOGGER.trace("Entering update account balance method with new amount " + amount + " for username: " + userName);
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			int paramterIndex = 0;
			String sql = "UPDATE USER_ACCOUNT SET BALANCE = BALANCE + ? WHERE U_NAME = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(++paramterIndex, amount);
			statement.setString(++paramterIndex, userName);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return result.getDouble("BALANCE");
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not update balance", e);
		}
		return null;
	}
	
}
