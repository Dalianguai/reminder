package com.ibm.iga.reminder.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.service.inter.IReminderEntryService;
import com.ibm.iga.reminder.service.inter.ISendReminderService;

@Service
public class SendMailScheduler {

	@Autowired
	private ISendReminderService sendReminderService;
	
	@Autowired
	private IReminderEntryService reminderEntryService;
	
	@Scheduled(cron = "0 0 * * * *")
	public void sendReminderDaily () {
		System.out.println("printing 1");
		List<ReminderEntry> reminders = reminderEntryService.getTodayReminders();
		sendReminderService.sendReminders(reminders);
	}	
}
