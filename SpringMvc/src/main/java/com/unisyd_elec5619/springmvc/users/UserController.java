package com.unisyd_elec5619.springmvc.users;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;
import com.unisyd_elec5619.springmvc.service.UserServiceImpl;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

@Controller
public class UserController {



	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="projectManager")
	private DatabaseProjectManager projectManager;
	
	private UserServiceImpl userService;
	
	@Autowired
	public void setUserServiceImpl(UserServiceImpl usersServiceImpl){
		this.userService = usersServiceImpl;
	}
	
	
	@RequestMapping(value = "/usersettings", method = RequestMethod.GET)
	public String user(Model mv) {
		
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = (currentUser.getUsername());
		
		
		System.out.println(name);
		Users loggedUser = userService.find(name);
		
		System.out.println("Settings reporting: " + loggedUser.getId());
		System.out.println("Settings reporting: " + loggedUser.getAuthority());
		

		// constructor takes view name, model name, model object
		// Second parameter "user" refers to commandName in JSP
		mv.addAttribute("user", new Users());
		
		String newPassword = null;
		
		
		mv.addAttribute("username", name);
		mv.addAttribute("confirmpassword", newPassword);
		
		mv.addAttribute("genders", Gender.values());
		mv.addAttribute("countries", Country.values());
		mv.addAttribute("projects", this.projectManager.getProjects());
		
		return "/usersettings";
	}

	@RequestMapping(value = "/userprofile")
	public String showProfile(Model model) {
		
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = (currentUser.getUsername());
		
		Map<String, Users> user = new HashMap<String, Users>();
	    user.put("users", this.userService.find(name));
		
	    System.out.println("Map model returning: " + user.get("users").getUsername());
		model.addAttribute("model", user);

		model.addAttribute("username", name);
		model.addAttribute("genders", Gender.values());
		model.addAttribute("countries", Country.values());
		model.addAttribute("projects", this.projectManager.getProjects());
	    
	    return "/userprofile";
	}

	@RequestMapping(value = "/usereditprofile", method = RequestMethod.POST)
	public String userEditProfile(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {

		ModelAndView mv = new ModelAndView();
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setUsername(currentUser.getUsername());
		
		Users updatingUser = userService.find(user.getUsername());
		
		user.setPassword(user.getPassword().substring(0,user.getPassword().length() -1));
		user.setId(updatingUser.getId());
		user.setAuthority(updatingUser.getAuthority());
		user.setEnabled(1);
		
		if (user.getPassword().equals(updatingUser.getPassword()) == false && user.getPassword() != null){
			System.out.println("Error in user input for edit profile");
			System.out.println(user.getPassword() + " " + updatingUser.getPassword());
			model.addAttribute("error", true);
			return user(model);
		}
		
		
		
		if (user.getNameFirst() == ""){
			user.setNameFirst(updatingUser.getNameFirst());
		}
		
		if (user.getNameLast() == ""){
			user.setNameLast(updatingUser.getNameLast());
		}
		
		if (user.getDetail() == ""){
			user.setDetail(updatingUser.getDetail());
		}


		System.out.println(user.getUsername());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Gender: " + user.getGender());
		System.out.println("Password: " + user.getPassword());
		System.out.println("New Password: " + user.getNewPassword());

		mv.addObject("user", user);
		mv.addObject("genders", Gender.values());
		mv.addObject("countries", Country.values());

		if (result.hasErrors()) {
			System.out.println("X");
			System.out.println(result);
			return user(model);
		} else {
			if (user.getNewPassword() != ""){
				if (user.getNewPassword().length() > 7){
					user.setPassword(user.getNewPassword());
					user.setNewPassword(null);
				} else {
					model.addAttribute("passworderror", true);
					return user(model);
				}
			}
			userService.update(user);
			
			return showProfile(model);
		}
	}

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}

	// For access denied 403 errors
	@RequestMapping(value = "/error")
	public String showError() {
		return "error";
	}

	@ModelAttribute("user")
    public  Users setUserName(HttpSession session) {
		
		Users u = new Users();
		u.setUsername((String)session.getAttribute("username"));
		
    return u;

    }

}