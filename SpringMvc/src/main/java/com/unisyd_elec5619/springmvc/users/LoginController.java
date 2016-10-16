package com.unisyd_elec5619.springmvc.users;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unisyd_elec5619.springmvc.service.AuthorityServiceImpl;
import com.unisyd_elec5619.springmvc.service.UserServiceImpl;

@Controller
public class LoginController {

	private UserServiceImpl userServiceImpl;
	private AuthorityServiceImpl authorityServiceImpl;

	@Autowired
	public void setUserServiceImpl(UserServiceImpl usersServiceImpl) {
		this.userServiceImpl =  usersServiceImpl;
	}
	
	@Autowired
	public void setAuthorityServiceImpl(AuthorityServiceImpl authorityServiceImpl){
		this.authorityServiceImpl = authorityServiceImpl;
	}

	@RequestMapping("/login")
	public String showLogin() {

		return "login";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {

		model.addAttribute("user", new Users());
		return "newaccount";
	}

	@RequestMapping(value = "createaccount", method = RequestMethod.POST)
	public String createAccount(@Valid Users user, BindingResult result) {
		
		
		
		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setAuthority("user");
		user.setEnabled(1);
		
		if (userServiceImpl.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists.");
		}

		try {
			Authority au = new Authority(user.getUsername(), user.getAuthority());
			authorityServiceImpl.save(au);
			userServiceImpl.save(user);
			
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists.");
			return "newaccount";
		}

		return "dashboard";
	}

}
