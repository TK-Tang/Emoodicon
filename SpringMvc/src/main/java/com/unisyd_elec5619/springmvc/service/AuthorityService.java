package com.unisyd_elec5619.springmvc.service;

import com.unisyd_elec5619.springmvc.users.Authority;
import com.unisyd_elec5619.springmvc.users.AuthorityDaoJpaImpl;

public interface AuthorityService {
	
	public void setAuthorityDao(AuthorityDaoJpaImpl authDao);
	
	public void save(Authority au);
	
	public Authority getAuthority(int id);
}
