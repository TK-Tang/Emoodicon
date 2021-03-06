package com.unisyd_elec5619.springmvc.calendar;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.service.CalendarServiceImpl;
import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;
import com.unisyd_elec5619.springmvc.service.UserServiceImpl;
import com.unisyd_elec5619.springmvc.users.Users;
@Controller
public class CalendarController {
	
	@Resource(name="projectManager")
	private DatabaseProjectManager projectManager;
	
	private UserServiceImpl userService;
	private CalendarServiceImpl calendarService;
	
	@Autowired
	public void setUserServiceImpl(UserServiceImpl usersServiceImpl){
		this.userService = usersServiceImpl;
	}
	
	@Autowired
	public void setCalendarServiceImpl(CalendarServiceImpl calendarServiceImpl){
		this.calendarService = calendarServiceImpl; 
	}
	
	
	//	public String showCalendar(@Valid Users user, BindingResult result) {
	@RequestMapping("/calendar/{id}")
	public String showCalendar(Model model, @PathVariable("id") long id) {
		
		int maxYear = 2000;
		
		
		System.out.println("/calendar/" + id);
		
		Project currentProject = projectManager.getProjectById(id);
		
		System.out.println(currentProject.getName());
		
		Calendar cal = new Calendar();
		cal.setProjectID(id);
		
		model.addAttribute("projects", this.projectManager.getProjects());
		model.addAttribute("calendarobject", cal);
		model.addAttribute("currentproject", currentProject);
		
		User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users currentUser = userService.find(loggedUser.getUsername());
		
		
		model.addAttribute("username", loggedUser.getUsername());
		
		// THIS HERE NEEDS TO CHANGE
		/* XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 
		 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 
		 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		 */
		List<Calendar> dateList = calendarService.retrieveUserProjectCalendar(currentUser, id);
		List<DateLog> dateLogList = new ArrayList<DateLog>();
		
		
		
		for (Calendar c : dateList){
			// System.out.println("Datelist for : " + currentUser.getUsername() + " Date: " + c.getCurrentDate() + " Mood: " + c.getMood());
			
			String dateString = c.getCurrentDate().toString();
			int year = Integer.parseInt(dateString.substring(0,4));
			
			if ( year > maxYear){
				maxYear = year;
			}
		}
		
		for (Calendar c : dateList){
			// System.out.println("Datelist for : " + currentUser.getUsername() + " Date: " + c.getCurrentDate() + " Mood: " + c.getMood());
			
			String dateString = c.getCurrentDate().toString();
			int year = Integer.parseInt(dateString.substring(0,4));
			int month = Integer.parseInt(dateString.substring(5,7));
			int day = Integer.parseInt(dateString.substring(8,dateString.length()));
			int mood = c.getMood();
			
			if ( year == maxYear){
				dateLogList.add(new DateLog(year, month, day, mood));
			}
		}
		
		List<MonthLog> allMonths = new ArrayList<MonthLog>();
		allMonths.add(new MonthLog("January", 1, 31));
		allMonths.add(new MonthLog("February", 2, 28));
		allMonths.add(new MonthLog("March", 3, 31));
		allMonths.add(new MonthLog("April", 4, 30));
		allMonths.add(new MonthLog("May", 5, 31));
		allMonths.add(new MonthLog("June", 6, 30));
		allMonths.add(new MonthLog("July", 7, 31));
		allMonths.add(new MonthLog("August", 8, 31));
		allMonths.add(new MonthLog("September", 9, 30));
		allMonths.add(new MonthLog("October", 10, 31));
		allMonths.add(new MonthLog("November", 11, 30));
		allMonths.add(new MonthLog("December", 12, 31));
		
		model.addAttribute("maxYear", maxYear);
		model.addAttribute("dateMonths", allMonths);
		model.addAttribute("dateLog", dateLogList);
		
		for (DateLog d : dateLogList){
			System.out.println("dateLog | Year:" + d.getYear() + " month: " + d.getMonth() + " day: " + d.getDay() + " mood: " + d.getMood());
		}
		
		
		return "/calendar";
	}
	
	@RequestMapping(value = "/setemote", method=RequestMethod.POST)
	public String setEmote(@Valid Calendar calendarobject, BindingResult result, Model model){
		
		if (calendarobject.getCurrentDate() != null){
			if (result.hasErrors()){
				System.out.println(result);		
			}
			
			User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Users currentUser = userService.find(loggedUser.getUsername());
			
			calendarobject.setUserID(currentUser.getId());
			
			
			calendarService.save(calendarobject);
			
			return showCalendar(model, calendarobject.getProjectID());
		} else {

			model.addAttribute("error", true);
			return showCalendar(model, calendarobject.getProjectID());
		}
		

	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));  
	}

}
