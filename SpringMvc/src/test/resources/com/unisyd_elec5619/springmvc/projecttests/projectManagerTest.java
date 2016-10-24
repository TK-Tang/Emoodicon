package com.unisyd_elec5619.springmvc.projecttests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.unisyd_elec5619.springmvc.domain.Project;
import com.unisyd_elec5619.springmvc.service.DatabaseProjectManager;
import com.unisyd_elec5619.springmvc.service.ProjectManager;

import junit.framework.TestCase;

public class projectManagerTest{

   private DatabaseProjectManager databaseProjectManager;
   private List<Project> projects;
   private static SessionFactory sessionFactory;
   
   @BeforeClass
   //initial session factory
   public static void setupSessionFactory() {
       try {
    	   sessionFactory = new Configuration().configure().buildSessionFactory();
       } catch (HibernateException e) {
           e.printStackTrace();
       }
   }
   
 
   
   @Test
   public void testaddProjectandGetProjectById(){
	   databaseProjectManager = new DatabaseProjectManager();
	   
	   Project project1 = new Project();
	   project1.setId(1);
	   project1.setPrice(123.00);
	   
	   //get current session
	   Session session = sessionFactory.getCurrentSession();
       session.beginTransaction();
       session.save(project1);
       session.getTransaction().commit();
	   
       //test addProject and getProjectById
	   databaseProjectManager.setSessionFactory(sessionFactory);
	   databaseProjectManager.addProject(project1);
	   assertEquals(project1,databaseProjectManager.getProjectById(1));
	   
	   //test deleteProject, if the only project in the db deleted, a null value will return
	   databaseProjectManager.deleteProject(1);
	   assertNull(databaseProjectManager.getProjects());
	   
   }
   
   @AfterClass
   public static void afterClass() {
	   sessionFactory.close();
   }
}
