package com.unisyd_elec5619.springmvc.users;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDaoJpaImpl")
public class UserDaoJpaImpl implements UserDao {
	
	/*
	ApplicationContext context =
	new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
	*/

	
    private SessionFactory sessionFactory ; //= (SessionFactory)context.getBean("sessionFactory");
    
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory =  sessionFactory;
	}

	@Override
	@Transactional
	public void insert(Users user) {
		System.out.println("UserDaoJpaImpl.insert(User user) called: " + user.getUsername());
		System.out.println("UserDaoJpaImpl.insert(User user) called: " + user.getPassword());
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	@Transactional
	public void update(Users user) {
		this.sessionFactory.getCurrentSession().update(user);
	}

	@Override
	@Transactional
	public void update(List<Users> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users find(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> find(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean exists(String username){
		return false;
	}


}
