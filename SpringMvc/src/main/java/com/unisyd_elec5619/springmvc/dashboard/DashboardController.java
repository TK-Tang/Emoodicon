package com.unisyd_elec5619.springmvc.dashboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisyd_elec5619.springmvc.service.ProjectManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
    private ProjectManager projectManager;

	@RequestMapping(value = {"/","/dashboard"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		boolean enabled = user.isEnabled();
		
		model.addAttribute("username", name);
		model.addAttribute("enabled", enabled);
//		model.addAttribute("projects", this.projectManager.getProjects());
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "dashboard";
	}
	
}
