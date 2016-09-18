package com.unisyd_elec5619.springmvc;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserDaoJpaImpl implements UserDao {

	
    private SessionFactory sessionFactory;
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(User user) {
		System.out.println("UserDaoJpaImpl.insert(User user) called: " + user.nameFirst);
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> find(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
