package com.unisyd_elec5619.springmvc.UserProject;

public interface ProjectUserService {
	
	public void deleteProject(ProjectUser p);
	
	public void addUserProject(ProjectUser p);
	
	public void findProject(int projectID);
	
	public void findUser(int userID);
}
