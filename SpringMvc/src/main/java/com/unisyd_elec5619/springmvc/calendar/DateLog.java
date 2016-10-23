package com.unisyd_elec5619.springmvc.calendar;

public class DateLog {
	
	public DateLog(int year, int month, int day, int mood){
		this.year = year;
		this.month = month;
		this.day = day;
		this.mood = mood;
	}
	
	private int year;
	
	private int month;
	
	private int day;
	
	private int mood;

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	
	public int getMood(){
		return mood;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMood(int mood){
		this.mood = mood;
	}
}
