package com.unisyd_elec5619.springmvc.usertests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unisyd_elec5619.springmvc.randomstring.SessionIdentifierGenerator;
import com.unisyd_elec5619.springmvc.service.AuthorityServiceImpl;
import com.unisyd_elec5619.springmvc.service.UserServiceImpl;
import com.unisyd_elec5619.springmvc.users.Authority;
import com.unisyd_elec5619.springmvc.users.Users;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

public class UsersRegistrationTest {

	@Test
	public void registrationTest() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
		UserServiceImpl usersService = (UserServiceImpl) context.getBean("userService");
		AuthorityServiceImpl authService = (AuthorityServiceImpl) context.getBean("authorityService");
		
		SessionIdentifierGenerator sdg = new SessionIdentifierGenerator();
		
		Users user1 = new Users();
		String randomString = sdg.nextSessionId();
		
		user1.setAuthority("user");
		user1.setEnabled(1);
		
		
		user1.setUsername(randomString);
		user1.setPassword("LetMeIn");
		user1.setNameFirst("Fregg");
		user1.setNameLast("Ley");
		user1.setGender(Gender.MALE);
		user1.setCountry(Country.Australia);
		user1.setDetail("All the details");
		
		
		
		if (usersService.find(user1.getUsername())  != null){
			System.out.println("Username already exists");
			return;
		} else {
			Authority au = new Authority(user1.getUsername(), user1.getAuthority());
			
			authService.save(au);
			usersService.save(user1);
		}
		
		Users foundUser = usersService.find(user1.getUsername());
		
		assertEquals(foundUser.getUsername(), user1.getUsername());
		assertEquals(foundUser.getNameFirst(), user1.getNameFirst());
		assertEquals(foundUser.getNameLast(), user1.getNameLast());
		assertEquals(foundUser.getDetail(), user1.getDetail());
		
		((ConfigurableApplicationContext) context).close();

	}

}
