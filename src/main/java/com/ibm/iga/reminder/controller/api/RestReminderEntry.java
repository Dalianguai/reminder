package com.ibm.iga.reminder.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.service.inter.IReminderEntryService;


/**  
 * 
 * @author CX
 * /api/reminder/entry/id/{id}  -- get , put, delete
 * /api/reminder/entry/today -get entries of today
 * /api/reminder/entry -post create entry
 *  /api/reminder/entry/id/request/{id}  -- get , put, delete
 * 
 */
@RestController
@RequestMapping("/api/reminder/entry")
public class RestReminderEntry {
	
	
	
	@Autowired
	private IReminderEntryService reminderEntryService;
	
	
	@RequestMapping(value ="/id/{id}" , method = RequestMethod.GET)
	public ReminderEntry getById(@PathVariable String id) {
		
		return reminderEntryService.getById(Integer.valueOf(id));
	}
	
	@RequestMapping(value ="/id/request/{id}" , method = RequestMethod.GET)
	public List<ReminderEntry> getByRequestId(@PathVariable String id) {
		
		return reminderEntryService.getByRequestId(Integer.valueOf(id));
	}
	
	@RequestMapping(value ="/today" , method = RequestMethod.GET)
	public List<ReminderEntry> getEntriesOfToday () {
		return reminderEntryService.getTodayReminders();
	}
	
	@RequestMapping(value ="/id/{id}" , method = RequestMethod.DELETE)
	public RestAPIStatus delete (@PathVariable String id) {
		if (reminderEntryService.delete(Integer.valueOf(id)) > 0) {
			return new RestAPIStatus().success();
		} else {
			return new RestAPIStatus().failure();
		}
	}
	
	@RequestMapping(value ="/id/request/{id}" , method = RequestMethod.DELETE)
	public RestAPIStatus deleteByRequestId (@PathVariable String id) {
		if (reminderEntryService.deleteByRequestId(Integer.valueOf(id)) > 0) {
			return new RestAPIStatus().success();
		} else {
			return new RestAPIStatus().failure();
		}
	}
	
	@RequestMapping(value ="/id/{id}" , method = RequestMethod.PUT)
	public RestAPIStatus updateById (@PathVariable String id, @RequestBody ReminderEntry entry) {
		entry.setId(Integer.valueOf(id));
		if (reminderEntryService.update(entry) > 0) {
			return new RestAPIStatus().success();
		} else {
			return new RestAPIStatus().failure();
		}
	}
	
	@RequestMapping(value ="" , method = RequestMethod.POST)
	public RestAPIStatus createEntry (@RequestBody ReminderEntry entry) {
		
		if (reminderEntryService.add(entry) > 0) {
			return new RestAPIStatus().success();
		} else {
			return new RestAPIStatus().failure();
		}
	}

}
