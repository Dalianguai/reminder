package com.ibm.iga.reminder.controller.api;

public class RestAPIStatus {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public RestAPIStatus success () {
		this.setStatus("success");
		return this;
	}
	public RestAPIStatus failure () {
		this.setStatus("faiulre");
		return this;
	}
}
