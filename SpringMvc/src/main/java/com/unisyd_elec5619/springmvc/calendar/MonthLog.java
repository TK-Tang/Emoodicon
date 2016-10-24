package com.unisyd_elec5619.springmvc.calendar;

public class MonthLog {
	
	public MonthLog(String month, int monthNumber, int days){
		this.month = month;
		this.days = days;
		this.monthNumber = monthNumber;
	}
	
	private String month;
	private int monthNumber;
	private int days;

	public String getMonth() {
		return month;
	}

	public int getDays() {
		return days;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	public void setDays(int days) {
		this.days = days;
	}

}
