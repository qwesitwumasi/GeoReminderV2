package com.g6.georeminderv2;

import java.util.Date;

import android.text.format.Time;

public class RemActions {

	// private variables for actions
	int aid;
	String title;
	String msg;
	String place;
	Date date;
	Time time;
	String plong;
	String plat;

	// Empty constructor
	public RemActions() {

	}

	// constructor with msg dialog
	public RemActions(String title, String msg, String place,
			Date date, Time time) {
		//this.aid = aid;
		this.title = title;
		this.msg = msg;
		this.place = place;
		this.date = date;
		this.time = time;
	}

	// constructor when there is no msg in the msg dialog box
	public RemActions( String title, String place, Date date, Time time) {
		//this.aid = aid;
		this.title = title;
		this.msg = null;
		this.place = place;
		this.date = date;
		this.time = time;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getPlong() {
		return plong;
	}

	public void setPlong(String plong) {
		this.plong = plong;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	

}
