package com.ibm.iga.reminder.service.inter;

import java.util.List;
import com.ibm.iga.reminder.model.ReminderEntry;

public interface ISendReminderService {

	public void sendReminder(ReminderEntry reminderEntry);
	public void sendReminders(List<ReminderEntry> reminderEntries);
}
