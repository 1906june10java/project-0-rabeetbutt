package com.revature.repository;

import java.util.List;
import com.revature.model.*;

public interface UserDAO {
	
	public List<User> getAllUsers();
	public boolean create(User user);
	public User findByName(String name);
	public void update(User user);
	public void delete(User user);
	
}
