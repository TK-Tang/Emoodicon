package com.unisyd_elec5619.springmvc.service;

import com.unisyd_elec5619.springmvc.users.Users;
import com.unisyd_elec5619.springmvc.users.UserDaoJpaImpl;

public interface UserService {
	
	 public void save(Users user);
	 
	 public boolean exists(String username);
	 
	 public void setUserDao(UserDaoJpaImpl userDao);
}
