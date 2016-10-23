package com.unisyd_elec5619.springmvc.calendar;

import java.io.Serializable;

// This could be wrong import
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Calendar")
public class Calendar implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCalendar")
	private int idCalendar;
	
	@NotNull
	@Column(name="Date")
	private Date currentDate;
	
	@NotNull
	@Column(name="Mood")
	private int mood;
	
	@NotNull
	@Column(name="projectID")
	private long projectID;
	
	@NotNull
	@Column(name="userID")
	private int userID;

	public int getIdCalendar() {
		return idCalendar;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public int getMood() {
		return mood;
	}
	
	public long getProjectID() {
		return projectID;
	}

	public int getUserID() {
		return userID;
	}

	public void setIdCalendar(int idCalendar) {
		this.idCalendar = idCalendar;
	}

	public void setCurrentDate(Date date) {
		this.currentDate = date;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	

}
