package com.hit.health.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConvertDate {

	private String today;
	private String nextYear;
	public ConvertDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyyy");
		Calendar cal = Calendar.getInstance();
		Date todayDate = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date nextYear = cal.getTime();
		this.today=dateFormat.format(todayDate);
		this.nextYear=dateFormat.format(nextYear);
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getNextYear() {
		return nextYear;
	}
	public void setNextYear(String nextYear) {
		this.nextYear = nextYear;
	}
	
	

	
}
