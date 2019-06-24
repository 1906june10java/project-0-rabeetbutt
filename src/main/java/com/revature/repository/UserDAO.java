package com.revature.repository;

import java.util.List;
import com.revature.model.*;

public interface UserDAO {
	
	public List<User> getAllUsers();
	public boolean create(User user);
	public String findUserName(String username);
	public String findPassword(String username);
	public Double updateBalance(String username, Double amount);
	public void delete(User user);
	
}
