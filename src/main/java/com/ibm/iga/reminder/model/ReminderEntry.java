package com.ibm.iga.reminder.model;

import java.util.Date;
/**
 * 
 * @author Jerry Wang
 *
 */
public class ReminderEntry {
	private long id;
	private ReminderRequest reminderRequest;
	private Date day;
	private boolean bSent;
	private Date sentDay;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ReminderRequest getReminderRequest() {
		return reminderRequest;
	}
	public void setReminderRequest(ReminderRequest reminderRequest) {
		this.reminderRequest = reminderRequest;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public boolean isbSent() {
		return bSent;
	}
	public void setbSent(boolean bSent) {
		this.bSent = bSent;
	}
	public Date getSentDay() {
		return sentDay;
	}
	public void setSentDay(Date sentDay) {
		this.sentDay = sentDay;
	}
	
	public void setSent () {
		setbSent(true);
		setSentDay(new Date());
	}
	
	@Override
	public String toString() {
		return "ReminderEntry [id=" + id + ", reminderRequest="
				+ reminderRequest + ", day=" + day + ", bSent=" + bSent
				+ ", sentDay=" + sentDay + "]";
	}
	
	
}
