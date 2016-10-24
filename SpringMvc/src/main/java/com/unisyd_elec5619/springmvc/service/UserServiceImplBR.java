package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisyd_elec5619.springmvc.dao.UserDaoBR;
import com.unisyd_elec5619.springmvc.domain.UserBR;

@Service
public class UserServiceImplBR implements UserServiceBR{

	
	UserDaoBR userDao;
	
	@Autowired
	public void setUserDao(UserDaoBR userDao) {
		this.userDao = userDao;
	}


	@Override
	public void save(UserBR user) {
		userDao.insert(user);
	}

}