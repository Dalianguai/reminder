package com.ibm.iga.reminder.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.springframework.test.context.web.WebAppConfiguration;

import com.ibm.iga.reminder.config.MailConfig;
import com.ibm.iga.reminder.config.RootConfiguration;
import com.ibm.iga.reminder.service.inter.IReminderEntryService;
import com.ibm.iga.reminder.service.inter.IReminderRequestService;
import com.ibm.iga.reminder.service.inter.ISendReminderService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={RootConfiguration.class})
public class TestSendMailService {

	@Autowired
	private ISendReminderService sendMailService;
	@Autowired
	private IReminderEntryService reminderEntryService;
	
	
	@Before
	public void setup () {
		
	}
	@Test
	public void testSend(){
		//sendMailService.sendReminder(null);
	}
	@Test
	public void testSendM () {
		System.out.println(reminderEntryService.getById(111));
		sendMailService.sendReminder(reminderEntryService.getById(111));
	}
}
