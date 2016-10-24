package com.unisyd_elec5619.springmvc.usertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import junit.framework.TestCase;
import org.junit.Test;

import com.unisyd_elec5619.springmvc.users.Users;
import com.unisyd_elec5619.springmvc.users.enums.Country;
import com.unisyd_elec5619.springmvc.users.enums.Gender;

public class BasicUserTest {
	
	private Users user = new Users();

	@Test
	public void Id() {
		int id = 1;
		assertNotNull(user.getId());
		user.setId(id);
		assertEquals(user.getId(), id);
	}
	
	@Test
	public void username(){
		String username = "TheHolyAsdf";
		user.setUsername(username);
		assertEquals(user.getUsername(), username);
	}
	
	@Test
	public void password(){
		String password = "LetMeIn";
		user.setPassword(password);
		assertEquals(user.getPassword(), password);
	}
	
	@Test
	public void enabled(){
		int enabled = 0;
		user.setEnabled(enabled);
		assertEquals(user.getEnabled(), enabled);
	}

	
	@Test
	public void nameFirst(){
		String nameFirst = "TK";
		user.setNameFirst("TK");
		assertEquals(user.getNameFirst(), nameFirst);
	}
	
	@Test
	public void nameLast(){
		String nameLast = "Tang";
		user.setNameLast(nameLast);
		assertEquals(user.getNameLast(), nameLast);
	}
	
	@Test
	public void detail(){
		String details = "I have the best details";
		user.setDetail(details);
		assertEquals(user.getDetail(), details);
	}
	
	@Test
	public void gender(){
		Gender g = Gender.MALE;
		user.setGender(g);
		assertEquals(user.getGender(), g);
	}
	
	@Test
	public void country(){
		Country c = Country.Australia;
		user.setCountry(c);
		assertEquals(user.getCountry(), c);
	}
	
	@Test
	public void authority(){
		String auth = "user";
		user.setAuthority(auth);
		assertEquals(user.getAuthority(), auth);
	}

}
