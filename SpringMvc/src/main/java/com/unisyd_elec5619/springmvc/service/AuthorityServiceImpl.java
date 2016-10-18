package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.unisyd_elec5619.springmvc.users.Authority;
import com.unisyd_elec5619.springmvc.users.AuthorityDaoJpaImpl;

public class AuthorityServiceImpl implements AuthorityService{
	
	AuthorityDaoJpaImpl authorityDao;
	
	@Autowired
	public void setAuthorityDao(AuthorityDaoJpaImpl authDao) {
		this.authorityDao = authDao;
	}

	@Override
	public void save(Authority au) {
		authorityDao.insert(au);
	}

	@Override
	public Authority getAuthority(int id) {
		return authorityDao.getAuthority(id);
	}

}
