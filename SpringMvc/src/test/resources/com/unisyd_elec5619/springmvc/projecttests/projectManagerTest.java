package com.unisyd_elec5619.springmvc.projecttests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.service.SimpleProjectManager;

import junit.framework.TestCase;

public class projectManagerTest extends TestCase{

	private SimpleProjectManager projectManager;
	private List<Project> projects;
	private static int PRODUCT_COUNT = 2;
	
	private static Double PROJECT_BUGET = new Double(20.50);
	private static String PROJECT_DESCRIPTION = "my project 1";
	private static String PROJECT_NAME = "Project Name 1";
	private static Date PROJECT_START_DATE = new Date(123);
	private static Date PROJECT_DEADLINE_DATE = new Date(321);
	private static String PROJECT_MANAGER = "mu project 1 manager";
	
	private static String PROJECT2_DESCRIPTION = "my project 2";
	private static Double PROJECT2_PRICE = new Double(150.10);
	private static String PROJECT2_NAME = "Project Name 2";
	private static Date PROJECT2_START_DATE = new Date(1234);
	private static Date PROJECT2_DEADLINE_DATE = new Date(4321);
	private static String PROJECT2_MANAGER = "mu project 2 manager";

	private static int POSITIVE_PRICE_INCREASE = 10;
	
	protected void setUp() throws Exception{
		projectManager = new SimpleProjectManager();
		projects = new ArrayList<Project>();
		
		Project project = new Project();
		project.setDescription(PROJECT_DESCRIPTION);
		project.setPrice(PROJECT_BUGET);
		project.setName(PROJECT_NAME);
		project.setProjectStartDate(PROJECT_START_DATE);
		project.setProjectDeadline(PROJECT_DEADLINE_DATE);
		project.setProjectManager(PROJECT_MANAGER);
		projects.add(project);
		
		project = new Project();
		project.setName(PROJECT2_NAME);
		project.setDescription(PROJECT2_DESCRIPTION);
		project.setPrice(PROJECT2_PRICE);
		project.setProjectStartDate(PROJECT2_START_DATE);
		project.setProjectDeadline(PROJECT2_DEADLINE_DATE);
		project.setProjectManager(PROJECT_MANAGER);
		projects.add(project);
		
		projectManager.setProjects(projects);
		
	}
	public void testGetProductsWithNoProdcuts(){
		projectManager = new SimpleProjectManager();
		assertNull(projectManager.getProjects());
	}
	
	public void testGetProjectsDescription(){
		List<Project> projects = projectManager.getProjects();
		assertNotNull(projects);
		assertEquals(PRODUCT_COUNT, projectManager.getProjects().size());
		
		Project project = projects.get(0);
		assertEquals(PROJECT_DESCRIPTION, project.getDescription());
		assertEquals(PROJECT_BUGET, project.getPrice());
		
		project = projects.get(1);
		assertEquals(PROJECT2_DESCRIPTION, project.getDescription());
		assertEquals(PROJECT2_PRICE, project.getPrice());
	}
	public void testGetProjectsName(){
		List<Project> projects = projectManager.getProjects();
		assertNotNull(projects);		
		Project project = projects.get(0);
		assertEquals(PROJECT_NAME, project.getName());
		
		project = projects.get(1);
		assertEquals(PROJECT2_NAME, project.getName());
	}
	public void testGetProjectsStartDate(){
		List<Project> projects = projectManager.getProjects();
		assertNotNull(projects);		
		Project project = projects.get(0);
		assertEquals(PROJECT_START_DATE, project.getProjectStartDate());
		
		project = projects.get(1);
		assertEquals(PROJECT2_START_DATE, project.getProjectStartDate());
	}
	public void testGetProjectsDeadline(){
		List<Project> projects = projectManager.getProjects();
		assertNotNull(projects);		
		Project project = projects.get(0);
		assertEquals(PROJECT_DEADLINE_DATE, project.getProjectDeadline());
		
		project = projects.get(1);
		assertEquals(PROJECT2_DEADLINE_DATE, project.getProjectDeadline());
	}
	public void testGetProjectsManager(){
		List<Project> projects = projectManager.getProjects();
		assertNotNull(projects);		
		Project project = projects.get(0);
		assertEquals(PROJECT_MANAGER, project.getProjectManager());
		
		project = projects.get(1);
		assertEquals(PROJECT2_MANAGER, project.getProjectManager());
	}
	
	public void testIncreasePriceWithNullListOfProducts() {
		try{
			projectManager = new SimpleProjectManager();
		}
		catch(NullPointerException ex){
			fail("Products list is null.");
		}
	}
	
	public void testIncreasePriceWithEmptyListProducts() {
		try{
			projectManager = new SimpleProjectManager();
			projectManager.setProjects(new ArrayList<Project>());
			projectManager.increasePrice(POSITIVE_PRICE_INCREASE);
		}
		catch(Exception ex) {
			fail("Products list is empty.");
		}
	}
	
	public void testIncreasePriceWithPositivePerentage(){
		projectManager.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.11;

		List<Project> products = projectManager.getProjects();
		Project product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice());
		
		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice());
	}
  
}
