package com.unisyd_elec5619.springmvc.users;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unisyd_elec5619.springmvc.service.UserServiceImpl;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/usersettings", method = RequestMethod.GET)
	public ModelAndView user() {
		
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = (currentUser.getUsername());

		// constructor takes view name, model name, model object
		// Second parameter "user" refers to commandName in JSP
		ModelAndView mv = new ModelAndView("usersettings", "user", new Users());
		
		mv.addObject("username", name);
		mv.addObject("genders", Gender.values());
		mv.addObject("countries", Country.values());
		
		return mv;
	}

	@RequestMapping(value = "/userprofile")
	public ModelAndView showProfile() {
		
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = (currentUser.getUsername());
		
		Map<String, Users> user = new HashMap<String, Users>();
	    user.put("users", this.userService.find(name));
		
	    System.out.println(user.get("users").getUsername());
		ModelAndView mv = new ModelAndView("userprofile", "model", user);

		mv.addObject("genders", Gender.values());
		mv.addObject("countries", Country.values());
	    
	    return mv;
	}

	@RequestMapping(value = "/usereditprofile", method = RequestMethod.POST)
	public ModelAndView userEditProfile(@Valid @ModelAttribute("user") Users user, BindingResult result) {

		ModelAndView mv = new ModelAndView();
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setUsername(currentUser.getUsername());

		System.out.println(result.getRawFieldValue("username"));
		System.out.println(currentUser.getUsername());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Gender: " + user.getGender());
		System.out.println("Password: " + user.getPassword());

		mv.addObject("u", user);
		mv.addObject("genders", Gender.values());
		mv.addObject("countries", Country.values());

		if (result.hasErrors()) {
			System.out.println("X");
			System.out.println(result);
			System.out.println("X");
			mv.setViewName("usersettings");
		} else {
			mv.setViewName("userprofile");

			userService.update(user);
		}

		return mv;
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute("user")
    public  Users setUserName(HttpSession session) {
		
		Users u = new Users();
		u.setUsername((String)session.getAttribute("username"));
		
    return u;

    }

}