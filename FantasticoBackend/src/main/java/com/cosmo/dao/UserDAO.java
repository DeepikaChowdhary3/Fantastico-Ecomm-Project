package com.cosmo.dao;

import java.util.List;

import com.cosmo.model.User;

public interface UserDAO {

	public boolean appendnewUser(User user);
	public boolean updateUserDetails(User user);
	public List<User> listofUsers();
	public User getUser(String userId);
	
}
