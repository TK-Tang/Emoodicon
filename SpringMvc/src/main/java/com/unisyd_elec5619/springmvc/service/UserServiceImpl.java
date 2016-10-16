package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.unisyd_elec5619.springmvc.users.UserDaoJpaImpl;
import com.unisyd_elec5619.springmvc.users.Users;

public class UserServiceImpl implements UserService{

	UserDaoJpaImpl userDao;
	
	@Autowired
	public void setUserDao(UserDaoJpaImpl userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(Users user) {
		userDao.insert(user);
	}

	@Override
	public boolean exists(String username) {
		return userDao.exists(username);
	}

}
