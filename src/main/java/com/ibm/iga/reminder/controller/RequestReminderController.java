package com.ibm.iga.reminder.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.iga.reminder.model.ReminderRequest;
import com.ibm.iga.reminder.service.inter.IReminderRequestService;


@Controller
@RequestMapping("/reminder/request")
public class RequestReminderController {
	
	@Autowired
	private IReminderRequestService reminderRequestService;

	private Principal principal;
	
	@ModelAttribute
	public void getCurrentUser (Principal principal) {
		this.principal = principal;
	}
	
	@RequestMapping("/create")
	public String openCreatePage () {
		return "add_request";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReminderRequest (ReminderRequest reminderRequest, @RequestParam("member") String mem) {
		reminderRequest.setOwner(principal.getName());
		reminderRequest.setMembers(mem.split(";"));	
		reminderRequestService.add(reminderRequest);
		return "list_requests";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
}
