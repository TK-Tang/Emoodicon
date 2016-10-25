package com.unisyd_elec5619.springmvc.UserProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="Project_user")
public class ProjectUser {
	
	@NotNull
	@Column(name="project_id")
	private int projectId;

	@NotNull
	@Column(name="user_id")
	private int userId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Project_usercol")
	@NotNull
	private int projectUserId;
	
	
	public int getProjectId() {
		return projectId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getProjectUserId() {
		return projectUserId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setProjectUserId(int projectUserId) {
		this.projectUserId = projectUserId;
	}
	
	

}
