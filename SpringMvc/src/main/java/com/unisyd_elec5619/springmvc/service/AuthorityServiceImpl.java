package com.unisyd_elec5619.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.users.Authority;
import com.unisyd_elec5619.springmvc.users.AuthorityDaoJpaImpl;

public class AuthorityServiceImpl implements AuthorityService{
	
	AuthorityDaoJpaImpl authorityDao;
	
	@Autowired
	public void setAuthorityDao(AuthorityDaoJpaImpl authDao) {
		this.authorityDao = authDao;
	}

	@Override
	@Transactional
	public void save(Authority au) {
		authorityDao.insert(au);
	}

	@Override
	@Transactional
	public Authority getAuthority(int id) {
		return authorityDao.getAuthority(id);
	}

}
