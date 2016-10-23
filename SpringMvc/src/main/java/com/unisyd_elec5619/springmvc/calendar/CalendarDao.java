package com.unisyd_elec5619.springmvc.calendar;

import java.util.List;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.users.Users;

public interface CalendarDao {
	
	public class CalendarDaoJpaImpl{
		
	}
	
	public void insert(Calendar calendar);
	
	public void update(Calendar calendar);
	
	public boolean exists(Calendar calendar);
	
	public List<Calendar> retrieveUserCalendarSet(int userID);
	
	public List<Calendar> retrieveProjectCalendarSet(long projectID);
	
	public List<Calendar> retrieveUserProjectCalendar(Users user, long projectId);

}
