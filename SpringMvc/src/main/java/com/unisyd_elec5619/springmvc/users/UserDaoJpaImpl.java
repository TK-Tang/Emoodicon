package com.unisyd_elec5619.springmvc.users;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
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
		this.sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	@Transactional
	public void update(List<Users> users) {
		
		for (Users u : users){
			this.sessionFactory.getCurrentSession().merge(u);
		}
		
	}

	@Override
	public void deleteUser(long userId) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		Users user = (Users) currentSession.get(Users.class, userId);
		currentSession.delete(user);
	}

	@Override
	public Users find(long userId) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		return (Users) currentSession.get(Users.class, userId);
	}

	@Override
	public List<Users> find(List<Long> userIds) {
		List<Users> userList = new ArrayList<Users>();
		Session currentSession = this.sessionFactory.getCurrentSession();
			
		for (Long l : userIds){
			userList.add((Users) currentSession.get(Users.class, l));
		}
		
		return userList;
	}
	
	@Override
	public boolean exists(long userId){
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		if (currentSession.get(Users.class, userId) != null){
			return true;
		} 
		return false;
	}
	
	@Override
	@Transactional
	public Users getUser(String username){
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		List<Users> userList = currentSession.createQuery("FROM Users WHERE username = :username").setParameter("username", username).list();
		
		Users user = userList.get(0);
		
		return user;
	}


}
