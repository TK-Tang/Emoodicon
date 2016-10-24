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
	private static String PROJECT_DESCRIPTION = "Chair";
	
	private static String PROJECT2_DESCRIPTION = "Table";
	private static Double PROJECT2_PRICE = new Double(150.10);
	
	private static int POSITIVE_PRICE_INCREASE = 10;
	
	protected void setUp() throws Exception{
		projectManager = new SimpleProjectManager();
		projects = new ArrayList<Project>();
		
		Project project = new Project();
		project.setDescription(PROJECT_DESCRIPTION);
		project.setPrice(PROJECT_BUGET);
		project.setName("project title");
		project.setProjectStartDate(new Date());
		project.setProjectDeadline(new Date());
		project.setProjectManager("New project Manager");
		projects.add(project);
		
		project = new Project();
		project.setDescription("Table");
		project.setPrice(PROJECT2_PRICE);
		projects.add(project);
		
		projectManager.setProjects(projects);
		
	}
	public void testGetProductsWithNoProdcuts(){
		projectManager = new SimpleProjectManager();
		assertNull(projectManager.getProjects());
	}
	
	public void testGetProducts(){
		List<Project> products = projectManager.getProjects();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, projectManager.getProjects().size());
		
		Project product = products.get(0);
		assertEquals(PROJECT_DESCRIPTION, product.getDescription());
		assertEquals(PROJECT_BUGET, product.getPrice());
		
		product = products.get(1);
		assertEquals(PROJECT2_DESCRIPTION, product.getDescription());
		assertEquals(PROJECT2_PRICE, product.getPrice());
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
