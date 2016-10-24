package com.unisyd_elec5619.springmvc.calendar;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.users.Users;

@Component("calendarDaoJpaImpl")
public class CalendarDaoJpaImpl implements CalendarDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void insert(Calendar calendar){
		System.out.println("DAO CalID is: " + calendar.getIdCalendar());
		System.out.println("DAO UserID is: " + calendar.getUserID());
		System.out.println("DAO ProjID is: " + calendar.getProjectID());
		System.out.println("DAO Mood is: " + calendar.getMood());
		System.out.println("DAO Date is: " + calendar.getCurrentDate());
		
		this.sessionFactory.getCurrentSession().save(calendar);
	}
	
	@Override
	@Transactional
	public void update(Calendar calendar){
		this.sessionFactory.getCurrentSession().merge(calendar);
		
	}
	
	@Override
	public boolean exists(Calendar calendar){
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		List<Calendar> checkID = currentSession.createQuery("FROM Calendar WHERE projectID = :projectID AND userID = :userID").setParameter("projectID", calendar.getProjectID()).setParameter("userID", calendar.getUserID()).list();
		
		for (Calendar c: checkID){
			if (c.getCurrentDate().equals(calendar.getCurrentDate())){
				System.out.println("Comparing entry:" + calendar.getCurrentDate() + " with existing entry: " + c.getCurrentDate());
				calendar.setIdCalendar(c.getIdCalendar());
				return true;
			}
		}

		return false;
	}
	
	@Override
	public List<Calendar> retrieveUserProjectCalendar(Users user, long projectId){
		Session currentSession = this.sessionFactory.getCurrentSession();
	
		List<Calendar> calendarList = currentSession.createQuery("FROM Calendar WHERE userId = :userId AND projectId = :projectId").setParameter("userId", user.getId()).setParameter("projectId", projectId).list();
		
		return calendarList;
	}
	
	@Override
	public List<Calendar> retrieveUserCalendarSet(int userId){
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Calendar> calendarList = currentSession.createQuery("FROM Calendar WHERE userId = :userId").setParameter("userId", userId).list();
		
		return calendarList;
	}
	
	@Override
	public List<Calendar> retrieveProjectCalendarSet(long projectId){
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Calendar> calendarList = currentSession.createQuery("FROM Calendar WHERE projectId = :projectId").setParameter("projectId", projectId).list();
		
		return calendarList;
	}
	
	@Override
	public int totalIndex(long projectId){
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Calendar> calendarList = currentSession.createQuery("FROM Calendar WHERE projectId = :projectId").setParameter("projectId", projectId).list();
		
		return calendarList.size();
	}
	
	@Override
	public int avgMood(long projectId){
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Calendar> calendarList = currentSession.createQuery("FROM Calendar WHERE projectId = :projectId").setParameter("projectId", projectId).list();
		
		int mood = 3;
		int negativeCount = 0;
		int positiveCount = 0;
		int neutralCount = 0;
		
		for(Calendar c : calendarList){
			if (c.getMood() == 0){
				negativeCount = negativeCount + 1;
			} else if (c.getMood() == 1){
				neutralCount = neutralCount  + 1;
			} else {
				positiveCount = positiveCount + 1;
			}
		}
		
		if (positiveCount > neutralCount){
			mood = 2;
		} else {
			mood = 1;
		}
		
		if (negativeCount > positiveCount && negativeCount > neutralCount ){
			mood = 0;
		}
		
		
		return mood;
	}

}
