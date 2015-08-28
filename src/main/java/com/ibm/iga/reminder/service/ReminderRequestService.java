package com.ibm.iga.reminder.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.iga.reminder.dao.ReminderEntryMapper;
import com.ibm.iga.reminder.dao.ReminderMemberMapper;
import com.ibm.iga.reminder.dao.ReminderRequestMapper;
import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.model.ReminderRequest;
import com.ibm.iga.reminder.service.inter.IReminderRequestService;


@Transactional
@Service
public class ReminderRequestService implements IReminderRequestService {

	@Autowired
	private ReminderRequestMapper reminderRequestMapper;
	@Autowired
	private ReminderMemberMapper reminderMemberMapper;
	@Autowired
	private ReminderEntryMapper reminderEntryMapper;
	@Override
	public long add(ReminderRequest request) {
		List<String> members = request.getMembers();
		long i = reminderRequestMapper.add(request);
		for (String o : members) {
			i = i > reminderMemberMapper.add(request.getId(), o) ? 0 : 1;
		}
		for (ReminderEntry re : getReminderEntriesFromRequest(request)) {
			reminderEntryMapper.add(re);
		}
		return i;
	}
	@Override
	public ReminderRequest getById(long id) {
		ReminderRequest rr = reminderRequestMapper.getById(id);
		return rr;
	}
	@Override
	public long delete(long id) {
		long i = reminderMemberMapper.delete(id);
		long j = reminderRequestMapper.delete(id);
		return i + j;
	}
	@Override
	public long update(ReminderRequest request) {
		long i = reminderRequestMapper.update(request);
		List<String> newMembers = request.getMembers();
		i = i + reminderMemberMapper.delete(request.getId());
		if ((newMembers != null) && (!newMembers.isEmpty())) {
			for (String o : newMembers) {
				i = i + reminderMemberMapper.add(request.getId(), o);
			}
		}
		return i;	
	}
	@Override
	public List<ReminderRequest> getByOwner(String owner) {
		List<ReminderRequest> rr = reminderRequestMapper.getByOwner(owner);
		return rr;
	}

	private List<ReminderEntry> getReminderEntriesFromRequest(ReminderRequest reminderRequest) {
		List<ReminderEntry> entries = new ArrayList<ReminderEntry>();
		ReminderEntry entry = null;
		if (reminderRequest.isRepeat()) {
			Date startDay = reminderRequest.getStartDay();
			Date endDay = reminderRequest.getEndDay();
			Calendar cStartDay = new GregorianCalendar();
			cStartDay.setTime(startDay);
			Calendar cEndDay = new GregorianCalendar();
			cEndDay.setTime(endDay);
			
			int dayOfMonth = cStartDay.get(Calendar.DAY_OF_MONTH);
			int dayOfWeek = cStartDay.get(Calendar.DAY_OF_WEEK);
			int weekOfMonth = cStartDay.get(Calendar.WEEK_OF_MONTH);
			
			
			if (reminderRequest.isDaily()) {
				for (; cStartDay.compareTo(cEndDay) <= 0; cStartDay.add(Calendar.DATE, 1)) {
					entry = new ReminderEntry();
					entry.setbSent(false);
					entry.setDay(cStartDay.getTime());
					entry.setReminderRequest(reminderRequest);
					entries.add(entry);
				}
			} else if (reminderRequest.isWeekly()) {
				for (; cStartDay.compareTo(cEndDay) <= 0; cStartDay.add(Calendar.DATE, 7)) {
					entry = new ReminderEntry();
					entry.setbSent(false);
					entry.setDay(cStartDay.getTime());
					entry.setReminderRequest(reminderRequest);
					entries.add(entry);
				}
			} else if (reminderRequest.isMonthlyByDay()) {
				
			} else if (reminderRequest.isMonthlyByDate()) {
				for (; cStartDay.compareTo(cEndDay) <= 0; cStartDay.add(Calendar.MONTH, 1)) {
					entry = new ReminderEntry();
					entry.setbSent(false);
					entry.setDay(cStartDay.getTime());
					entry.setReminderRequest(reminderRequest);
					entries.add(entry);
				}
			}
			
		} else {
			entry = new ReminderEntry();
			entry.setbSent(false);
			entry.setDay(reminderRequest.getStartDay());
			entry.setReminderRequest(reminderRequest);
			entries.add(entry);
		}
		
		return entries;
	}
}
