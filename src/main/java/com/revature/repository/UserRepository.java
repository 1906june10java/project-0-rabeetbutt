package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.model.User;

import com.revature.util.ConnectionUtil;

public class UserRepository implements UserDAO{

	private static final Logger LOGGER = Logger.getLogger(UserRepository.class);
	
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User user) {
		LOGGER.trace("Entering create method with parameter: " + user);
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			int parameterIndex = 0;
			String sql = "INSERT INTO USER_ACCOUNT VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++parameterIndex, user.getFirstName());	
			statement.setString(++parameterIndex, user.getLastName());
			statement.setString(++parameterIndex, user.getAccount().getUserName());
			statement.setString(++parameterIndex, user.getAccount().getPassword());
			statement.setString(++parameterIndex, user.getAccount().getAccountID());
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
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		UserDAO repository = new UserRepository();
		repository.create(
				new User(
						"Connor",
						"Murphy",
						new Account("cmurphy123", "Password1", "cm109a2223", 3000000D)
						)
				);
		
	}
	
	
}
