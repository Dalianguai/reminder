package com.ibm.iga.reminder.service.inter;

import java.util.List;

import com.ibm.iga.reminder.model.ReminderEntry;

public interface IReminderEntryService {

	public long add (ReminderEntry reminderEntry); 
	public long delete (long id); //id=primary key, not request id
	public long deleteByRequestId (long id);
	public ReminderEntry getById (long id);
	public List<ReminderEntry> getByRequestId(long id);
	public long update (ReminderEntry reminderEntry);
	public long setSent(ReminderEntry reminderEntry);
	public List<ReminderEntry> getTodayReminders ();

}
