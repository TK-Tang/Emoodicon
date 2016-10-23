package com.unisyd_elec5619.springmvc.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
import com.unisyd_elec5619.springmvc.domain.EmojiFamilyImpl;
import com.unisyd_elec5619.springmvc.domain.UserBR;

@Repository("emojiFamilyDao")
@Transactional
public class EmojiFamilyDaoJpaImpl implements EmojiFamilyDao {
	
    private SessionFactory sessionFactory;
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public void insert(EmojiFamily ef) {
		this.sessionFactory.getCurrentSession().save(ef);
	}

	public void update(EmojiFamily ef) {
		// TODO Auto-generated method stub
		
	}


	public void update(List<UserBR> users) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		String query;
		query = "DELETE FROM EmojiFamilyImpl WHERE id=" + id;
		Query queryResult = this.sessionFactory.getCurrentSession().createQuery(query);
		queryResult.executeUpdate();
	}

	public UserBR find(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserBR> find(List<Long> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<EmojiFamily> getAll() {
		return new HashSet<EmojiFamily>(this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class).list());
	}

	@Override
	public EmojiFamily getEmojiFamilyById(Long id){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class);
		crit.add(Restrictions.eq("id", id.intValue()));
		return (EmojiFamily) crit.list().get(0);
	}
	
	@Override
	public void saveOrUpdate(EmojiFamily emojiFamily) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(emojiFamily);
	}


	@Override
	public EmojiFamily getDefault() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class);
		crit.add(Restrictions.eq("defaultEmoji", true));
		return (EmojiFamily) crit.list().get(0);// there should only ever be one default
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<EmojiFamily> getNonDefaults() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class);
		crit.add(Restrictions.eq("defaultEmoji", false));
		return new HashSet<EmojiFamily>( crit.list());
	}


	@Override
	public List emojiFamilyNames() {
		String query;
		query = "SELECT name FROM EmojiFamilyImpl";
		Query queryResult = this.sessionFactory.getCurrentSession().createQuery(query);
		 return new ArrayList<String>(queryResult.list());
	}

}
