package com.unisyd_elec5619.springmvc.domain;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import com.unisyd_elec5619.springmvc.users.Users;


@Entity
@Table(name="Project")
public class Project implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="Id", unique = true, nullable = false)
	private long id;
	
	@Column(name="Description")
    private String description;
	
	@Column(name="Price")
    private Double price;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="ProjectStartDate")
	private Date projectStartDate;
	
	@Column(name="ProjectDeadline")
	private Date projectDeadline;
		
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinTable(name = "Project_user", joinColumns = {
			@JoinColumn(name = "project_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "user_id",
					nullable = false, updatable = false) })
    private Set<Users> users = new HashSet<Users>(0);

    public Set<Users> getUsers() {
		return this.users;
	}
    public void setUsers(Set<Users> users){
    	this.users = users;
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
    	//System.out.println("get price");
        return price;
    }
    
    public void setPrice(Double price) {
    	//System.out.println("get price");
        this.price = price;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public Date getProjectStartDate(){
    	return this.projectStartDate;
    }
    
    public void setProjectStartDate(Date projectStartDate){
    	this.projectStartDate = projectStartDate;
    }
    public void setProjectStartDateDefault(){
    	java.util.Date today = new java.util.Date();
        today.setTime(0);
		projectStartDate = new Date(today.getTime());
    }
    public void setProjectStartDate(java.util.Date date){
    	projectStartDate = new Date(date.getTime());
    }
    
    
    public Date getProjectDeadline(){
    	return this.projectDeadline;
    }
    
    public void setProjectDeadlineDefault(){
    	java.util.Date today = new java.util.Date();
        today.setTime(0);
		projectDeadline = new Date(today.getTime());
    }
    
    public void setProjectDeadline(java.util.Date date){
    	projectDeadline = new Date(date.getTime());
    }
    
    public void setProjectDeadline(Date projectDeadline){
    	this.projectDeadline = projectDeadline;
    }
  /*  
    @OneToMany(mappedBy = "Project", cascade = CascadeType.ALL)
    public Set<ProjectUser> getProjectUsers(){
    	return this.projectUsers;
    }
    /
    
    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "project_user", joinColumns = {
			@JoinColumn(name = "Id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "Id",
					nullable = false, updatable = false) })    
    public Set<Users> getUsers(){
    	return this.users;
    }
    
    public void setUsers(Set<Users> users){
    	this.users = users;
    }
    
    */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}
