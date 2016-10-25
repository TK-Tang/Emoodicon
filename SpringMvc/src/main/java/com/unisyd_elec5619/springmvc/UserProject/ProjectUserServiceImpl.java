package com.unisyd_elec5619.springmvc.UserProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProjectUserServiceImpl implements ProjectUserService{
	
	ProjectUserDaoImpl puDao;
	
	@Autowired
	public void setProjectUserDaoImpl(ProjectUserDaoImpl puDao){
		this.puDao = puDao;
	}
	
	public void deleteProject(ProjectUser p){
		List<ProjectUser> puList = puDao.findProject(p.getProjectId());
		
		for(ProjectUser pu : puList){
			puDao.delete(pu);
		}
	}
	
	public void addUserProject(ProjectUser p){
		puDao.insert(p);
	}
	
	public void findProject(int projectID){
		puDao.findProject(projectID);
	}
	
	public void findUser(int userID){
		puDao.findUser(userID);
	}
	
}
