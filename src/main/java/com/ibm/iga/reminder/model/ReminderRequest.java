package com.ibm.iga.reminder.model;

import java.util.Date;
import java.util.List;
/**
 * 
 * @author Jerry Wang
 *
 */
public class ReminderRequest {
 
	private long id;
	private String owner;
	private String subject;
	private String description;
	private List<String> members;
	private boolean repeat = false;
	private boolean daily = false;
	private boolean weekly = false;
	private boolean monthlyByDay = false;
	private boolean monthlyByDate = false;
	private int day = 0;
	private Date startDay = new Date();
	private Date endDay = new Date();
	private Date createDate = new Date();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	public boolean isRepeat() {
		return repeat;
	}
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	public boolean isDaily() {
		return daily;
	}
	public void setDaily(boolean daily) {
		this.daily = daily;
	}
	public boolean isWeekly() {
		return weekly;
	}
	public void setWeekly(boolean weekly) {
		this.weekly = weekly;
	}
	public boolean isMonthlyByDay() {
		return monthlyByDay;
	}
	public void setMonthlyByDay(boolean monthlyByDay) {
		this.monthlyByDay = monthlyByDay;
	}
	public boolean isMonthlyByDate() {
		return monthlyByDate;
	}
	public void setMonthlyByDate(boolean monthlyByDate) {
		this.monthlyByDate = monthlyByDate;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ReminderRequest [id=" + id + ", owner=" + owner + ", subject="
				+ subject + ", description=" + description + ", members="
				+ members + ", repeat=" + repeat + ", daily=" + daily
				+ ", weekly=" + weekly + ", monthlyByDay=" + monthlyByDay
				+ ", monthlyByDate=" + monthlyByDate + ", day=" + day
				+ ", startDay=" + startDay + ", endDay=" + endDay
				+ ", createDate=" + createDate + "]";
	}


	
}
