package com.unisyd_elec5619.springmvc.dao;

import java.util.List;

import com.unisyd_elec5619.springmvc.domain.UserBR;

public interface UserDaoBR {	

	
	    public class UserDaoJpaImpl {

	}

		public void insert(UserBR user);

	    public void update(UserBR user);

	    public void update(List<UserBR> users);

	    public void delete(long userId);

	    public UserBR find(long userId);

	    public List<UserBR> find(List<Long> userIds);
	
}

