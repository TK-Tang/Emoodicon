package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.users.UserDaoJpaImpl;
import com.unisyd_elec5619.springmvc.users.Users;

public class UserServiceImpl implements UserService{

	UserDaoJpaImpl userDao;
	
	@Autowired
	public void setUserDao(UserDaoJpaImpl userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void save(Users user) {
		userDao.insert(user);
	}

	@Override
	@Transactional
	public boolean exists(long id) {
		return userDao.exists(id);
	}
	
	@Override
	@Transactional
	public Users find(String username){
		return userDao.getUser(username);
	}

	@Override
	@Transactional
	public void update(Users user){
		userDao.update(user);
	}
	
}
