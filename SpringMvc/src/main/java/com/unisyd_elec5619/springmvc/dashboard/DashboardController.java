package com.unisyd_elec5619.springmvc.dashboard;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisyd_elec5619.springmvc.service.CalendarServiceImpl;
import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;

/**
 * Handles requests for the application home page.
 */

@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Resource(name="projectManager")
	private DatabaseProjectManager projectManager;
	
	private CalendarServiceImpl calendarService;
	
	@Autowired
	public void setCalendarServiceImpl(CalendarServiceImpl calendarServiceImpl){
		this.calendarService = calendarServiceImpl; 
	}

	@RequestMapping(value = {"/","/dashboard", "/index.html", "/index", "/**/index", "/**/index.html"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		boolean enabled = user.isEnabled();
		
		model.addAttribute("username", name);
		model.addAttribute("enabled", enabled);
		model.addAttribute("projects", this.projectManager.getProjects());
		
		//FEED A PROPER PROJECT ID
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		model.addAttribute("totalIndex", calendarService.getTotalIndex(53));
		model.addAttribute("overallMood", calendarService.getAvgMood(53));
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "dashboard";
	}
	
}
