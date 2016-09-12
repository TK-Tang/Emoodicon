package Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.Offer;
import DAO.User;
import ServiceLayers.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping("/Login")
	public String showLogin(){
		
		System.out.println("do sysout even workat all?");
		return "Login";
	}
	
	@RequestMapping("/NewAccount")
	public String showNewAccount(Model model){
		
		System.out.println("wtf");
		model.addAttribute("user", new User());
		return "NewAccount";
	}
	
	@RequestMapping(value = "CreateAccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result){
		System.out.println("do sysout even work?");
		if (result.hasErrors()){
			System.out.println("help");
			return "CreateAccount";
		}
		
		System.out.println("help2");
		user.setAuthority("user");
		user.setEnabled(true);
		
		usersService.create(user);
		
		return "AccountCreated";
	}
	

}
