package com.unisyd_elec5619.springmvc.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.domain.UserBR;

@Component
@Transactional
public class UserDaoJpaImplBR implements UserDaoBR {

	
    private SessionFactory sessionFactory;
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(UserBR user) {
		System.out.println("UserDaoJpaImpl.insert(User user) called: " + user.getNameFirst());
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(UserBR user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<UserBR> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBR find(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBR> find(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
