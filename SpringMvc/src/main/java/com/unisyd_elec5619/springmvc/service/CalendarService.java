package com.unisyd_elec5619.springmvc.service;

import java.util.List;

import com.unisyd_elec5619.springmvc.calendar.Calendar;
import com.unisyd_elec5619.springmvc.calendar.CalendarDaoJpaImpl;
import com.unisyd_elec5619.springmvc.users.Users;

public interface CalendarService {
	
	public void setCalendarDao(CalendarDaoJpaImpl calDao);
	
	public void save(Calendar calendar);
	
	public void exist(Calendar calendar);
	
	public List<Calendar> retrieveProjectCalendarSet(Calendar calendar);
	
	public List<Calendar> retrieveUserCalendarSet(Calendar calendar);
	
	public List<Calendar> retrieveUserProjectCalendar(Users user, long projectId);
	
	
}
