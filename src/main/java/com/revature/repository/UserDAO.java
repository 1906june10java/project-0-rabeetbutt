package com.revature.repository;

import java.util.List;
import com.revature.model.*;

public interface UserDAO {
	
	public boolean create(User user);
	public String findUserName(String username);
	public String findPassword(String username);
	public Double getBalance(String userName);
	public Double updateBalance(String username, Double amount);

	
}
