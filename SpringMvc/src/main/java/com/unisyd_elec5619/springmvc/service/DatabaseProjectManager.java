package com.unisyd_elec5619.springmvc.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unisyd_elec5619.springmvc.domain.Project;


@Service(value="projectManager")
@Transactional
public class DatabaseProjectManager implements ProjectManager {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addProject(Project project) {
		this.sessionFactory.getCurrentSession().save(project);
	}
	
	public Project getProjectById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Project project = (Project) currentSession.get(Project.class, id);
		return project;
	}
	
	public void updateProject(Project project) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(project);
	}
	
	public void deleteProject(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Project project = (Project) currentSession.get(Project.class, id);
		currentSession.delete(project);
	}

	@Override
	public void increasePrice(int percentage) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<Project> projects = currentSession.createQuery("FROM Project").list();
		
		if (projects != null) {
            for (Project project : projects) {
                double newPrice = project.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                project.setPrice(newPrice);
                currentSession.save(project);
            }
        }
	}

	@Override
	public List<Project> getProjects() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Project").list();
	}

}
