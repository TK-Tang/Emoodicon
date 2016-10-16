package com.unisyd_elec5619.springmvc.users;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	/*
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView user() {
    	
        ModelAndView mv = new ModelAndView("userForm", "user", new Users()); // constructor takes model name, view name, model object
        mv.addObject("genders", Gender.values());
        mv.addObject("countries", Country.values());
        return mv;
    }

	// Going to retask this for user settings
	// Commented out to disable a bug - extraneous feature for now
	
    @RequestMapping(value = "/result")
    //public ModelAndView processUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
    public ModelAndView processUser(Users user, BindingResult result) {
        System.out.println("result.hasErrors(): " + result.hasErrors());
        ModelAndView mv = new ModelAndView();
        mv.addObject("u", user);
        mv.addObject("genders", Gender.values());
        mv.addObject("countries", Country.values());

        if (result.hasErrors()) {
            mv.setViewName("userForm");
        } else {
            mv.setViewName("userResult");
            
            userService.save(user);
        }

        return mv;
    }
    */
    

}