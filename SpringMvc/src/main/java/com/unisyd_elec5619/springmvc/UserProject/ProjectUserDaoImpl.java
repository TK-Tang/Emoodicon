package com.unisyd_elec5619.springmvc.UserProject;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("projectUserDaoImpl")
public class ProjectUserDaoImpl implements ProjectUserDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(ProjectUser p) {
		
		this.sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public void delete(ProjectUser p) {

		this.sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public List<ProjectUser> findProject(int projectID) {
		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Project_user WHERE project_id = :projectId").setParameter("projectId", projectID).list();
	}

	@Override
	public List<ProjectUser> findUser(int userID) {
		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Project_user WHERE user_id = :userId").setParameter("userId", userID).list();
	}

}
