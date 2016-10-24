package com.unisyd_elec5619.springmvc.projecttests;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.users.Users;

import junit.framework.TestCase;

public class ProjectTest extends TestCase{
	private Project project;
	
	protected void setUp() throws Exception {
		project = new Project();
	}
	
	// test case to test if relation is existing 
	public void testSetGetUsers() {
		Users user = new Users();
		user.setDetail("User1");
		Users user2 = new Users();
		user2.setDetail("User2");
		Users user3 = new Users();
		user3.setDetail("User5");
		
		assertEquals(2,project.getUsers().size());
		assertTrue(project.getUsers().contains(user));
		assertFalse(project.getUsers().contains(user3));		
    }
	public void testSetAndGetId(){
		long testId = 2333;
		assertNotNull(project.getId());
		project.setId(testId);
		assertEquals(testId, project.getId());
	}
	
	public void testSetAndGetDescription(){
		String testDescription = "this is description";
		assertNull(project.getDescription());
		project.setDescription(testDescription);
		assertEquals(testDescription, project.getDescription());
	}
	
	public void testSetAndGetPrice(){
		double testPrice = 100.00;
		assertEquals(0,0,0);
		project.setPrice(testPrice);
		assertEquals(testPrice,project.getPrice(),0);
	}
   
	public void testSetAndGetName(){
		String testName = "this is name";
		assertNull(project.getName());
		project.setName(testName);
		assertEquals(testName, project.getName());
	}
    
	public void testSetAndGetProjectStartDate(){
		Date testDate = new Date(34567);
		assertNull(project.getProjectStartDate());
		project.setProjectStartDate(testDate);
		assertEquals(testDate, project.getProjectStartDate());
	}
	
    public void testGetProjectDefaultStartDate(){
    	java.util.Date testDate = new java.util.Date();
        testDate.setTime(0);
        project.setProjectStartDateDefault();
		assertEquals(testDate, project.getProjectStartDate());
    }
	public void testSetAndGetProjectDeadline(){
		Date testDate = new Date(34567);
		assertNull(project.getProjectDeadline());
		project.setProjectDeadline(testDate);
		assertEquals(testDate, project.getProjectDeadline());
	}
	
    public void testGetProjectDefaultDealineDate(){
    	java.util.Date testDate = new java.util.Date();
        testDate.setTime(0);
        project.setProjectDeadlineDefault();
		assertEquals(testDate, project.getProjectDeadline());
    }
   
}
