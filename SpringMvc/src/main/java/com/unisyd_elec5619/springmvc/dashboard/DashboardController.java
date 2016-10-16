package com.unisyd_elec5619.springmvc.dashboard;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	
	@RequestMapping("/dashboard")
	public String showDashboard(ModelMap model){
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		boolean enabled = user.isEnabled();
		
		System.out.println(enabled);
		
		model.addAttribute("username", name);
		model.addAttribute("enabled", enabled);
		
		return "dashboard";
	}
}
