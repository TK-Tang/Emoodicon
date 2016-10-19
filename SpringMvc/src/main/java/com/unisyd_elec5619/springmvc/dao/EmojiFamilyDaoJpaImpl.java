package com.unisyd_elec5619.springmvc.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.domain.EmojiFamily;
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

	public void delete(long userId) {
		// TODO Auto-generated method stub
		
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
	public void saveOrUpdate(EmojiFamily emojiFamily) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(emojiFamily);
	}


	@Override
	public EmojiFamily getDefault() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class);
		crit.add(Restrictions.eq("defaultEmoji", true));
		return (EmojiFamily) crit.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<EmojiFamily> getNonDefaults() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(EmojiFamily.class);
		crit.add(Restrictions.eq("defaultEmoji", false));
		return new HashSet<EmojiFamily>( crit.list());
	}

}
