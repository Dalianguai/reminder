package com.ibm.iga.reminder.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ibm.iga.reminder.service.inter.ISendMailScheduler;

@Service
public class SendMailScheduler implements ISendMailScheduler {

	@Scheduled(fixedDelay = 5000)
	@Override
	public void sendReminderDaily () {
		System.out.println("printing 1");
	}
	
}
