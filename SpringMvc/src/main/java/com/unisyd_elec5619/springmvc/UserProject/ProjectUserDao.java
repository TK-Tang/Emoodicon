package com.unisyd_elec5619.springmvc.UserProject;

import java.util.List;

public interface ProjectUserDao {
	
	public class ProjectUserJpaImpl {
		
	}
	
	public void insert(ProjectUser p);
	
	public void delete(ProjectUser p);
	
	public List<ProjectUser> findProject(int projectID);
	
	public List<ProjectUser> findUser(int userID);

}
