package com.unisyd_elec5619.springmvc.users;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("authorityDaoJpaImpl")
public class AuthorityDaoJpaImpl implements AuthorityDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	
	@Override
	@Transactional
	public void insert(Authority Au){
		this.sessionFactory.getCurrentSession().save(Au);
	}
	
	@Override
	public Authority getAuthority(int id){
		return (Authority) this.sessionFactory.getCurrentSession().get(Authority.class, id);
	}

}
