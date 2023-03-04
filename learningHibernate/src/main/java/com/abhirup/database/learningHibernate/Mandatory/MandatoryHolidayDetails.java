package com.abhirup.database.learningHibernate.Mandatory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Holiday")
public class MandatoryHolidayDetails {

	public MandatoryHolidayDetails(String dayOfTheWeek, String date, String event) {
		super();
		this.dayOfTheWeek = dayOfTheWeek;
		this.date = date;
		this.event = event;
	}
	
	public MandatoryHolidayDetails(){
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dayOfTheWeek;
	private String date;
	private String event;
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "Mandatory [dayOfTheWeek=" + dayOfTheWeek + ", date=" + date + ", event=" + event + "]";
	}
	
	
	
}
