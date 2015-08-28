package com.ibm.iga.reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.iga.reminder.dao.ReminderEntryMapper;
import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.service.inter.IReminderEntryService;

@Transactional
@Service
public class ReminderEntryService implements IReminderEntryService {

	@Autowired
	ReminderEntryMapper reminderEntryMapper;
	@Override
	public long add(ReminderEntry reminderEntry) {
		return reminderEntryMapper.add(reminderEntry);
	}

	@Override
	public long delete(long id) {
		return reminderEntryMapper.delete(id);
	}

	@Override
	public long deleteByRequestId(long id) {
		return reminderEntryMapper.deleteByRequestId(id);
	}

	@Override
	public ReminderEntry getById(long id) {
		return reminderEntryMapper.getById(id);
	}

	@Override
	public List<ReminderEntry> getByRequestId(long id) {
		return reminderEntryMapper.getByRequestId(id);
	}

	@Override
	public long update(ReminderEntry reminderEntry) {
		return reminderEntryMapper.update(reminderEntry);
	}

	@Override
	public List<ReminderEntry> getTodayReminders() {
		return reminderEntryMapper.getTodayReminderEntries();
	}

	@Override
	public long setSent(ReminderEntry reminderEntry) {
		reminderEntry.setSent();
		return update(reminderEntry);
	}

}
