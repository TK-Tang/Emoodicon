package com.unisyd_elec5619.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.calendar.Calendar;
import com.unisyd_elec5619.springmvc.calendar.CalendarDaoJpaImpl;
import com.unisyd_elec5619.springmvc.users.Users;


public class CalendarServiceImpl implements CalendarService {
	
	CalendarDaoJpaImpl calendarDao;
	
	@Autowired
	@Transactional
	@Override
	public void setCalendarDao(CalendarDaoJpaImpl calDao){
		this.calendarDao = calDao;
	}
	
	
	@Transactional
	@Override
	public void save(Calendar calendar){
		if (calendarDao.exists(calendar) == true){
			System.out.println("Overwriting existing date entry");
			calendarDao.update(calendar);
		} else {
			System.out.println("Inserting new date entry");
			calendarDao.insert(calendar);
		}

	}
	
	@Transactional
	@Override
	public void exist(Calendar calendar){
		calendarDao.exists(calendar);
	}
	
	@Transactional
	@Override
	public List<Calendar> retrieveProjectCalendarSet(Calendar calendar){
		return calendarDao.retrieveProjectCalendarSet(calendar.getProjectID());
	}
	
	@Transactional
	@Override
	public List<Calendar> retrieveUserCalendarSet(Calendar calendar){
		return calendarDao.retrieveUserCalendarSet(calendar.getUserID());
	}
	
	@Transactional
	@Override
	public List<Calendar> retrieveUserProjectCalendar(Users user, long projectId){
		return calendarDao.retrieveUserProjectCalendar(user, projectId);
	}
	
	@Transactional
	@Override
	public int getTotalIndex(long projectId){
		return calendarDao.totalIndex(projectId);
	}

}
