package com.ibm.iga.reminder.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ibm.iga.reminder.config.MyBatisConfig;
import com.ibm.iga.reminder.config.RootConfiguration;
import com.ibm.iga.reminder.dao.ReminderEntryMapper;
import com.ibm.iga.reminder.dao.ReminderMemberMapper;
import com.ibm.iga.reminder.dao.ReminderRequestMapper;
import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.model.ReminderRequest;
import com.ibm.iga.reminder.scheduling.SendMailScheduler;
import com.ibm.iga.reminder.service.inter.IReminderEntryService;
import com.ibm.iga.reminder.service.inter.IReminderRequestService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={RootConfiguration.class})

public class TestReminderRequestImpl {

	@Autowired
	SendMailScheduler   sendMailService1;
	@Autowired
	IReminderRequestService reminderRequestService;
	
	@Autowired
	ReminderMemberMapper reminderMemberMapper;
	@Autowired
	ReminderRequestMapper reminderRequestMapper;
	@Autowired
	ReminderEntryMapper reminderEntryMapper;
	@Autowired
	IReminderEntryService reminderEntryService;
	
	ReminderRequest reminderRequest;
	ReminderEntry reminderEntry;
	@Before
	public void setup () {
		reminderRequest = new ReminderRequest();
		//reminderRequest.setId(11);
		reminderRequest.setDaily(true);
		reminderRequest.setDescription("abfgftftdddfc");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		reminderRequest.setEndDay(c.getTime());
		reminderRequest.setMonthlyByDate(false);
		reminderRequest.setMonthlyByDay(false);
		reminderRequest.setOwner("jiaihiw@cn.ibm.com");
		reminderRequest.setRepeat(true);
		reminderRequest.setStartDay(new Date());
		reminderRequest.setSubject("test 111");
		reminderRequest.setWeekly(false);
		reminderRequest.setCreateDate(new Date());
		String[] m = new String[4];
		m[0] = "wesfyfyd@cn.ibm.com";
		m[1] ="wwwddsdw@cn.dsfibm.com";
		m[2] ="dfdhhhsfdd@cn.ibm.com";
		m[3] ="dfdsfdd@cnsd.ibm.com";
		reminderRequest.setMembers(m);
		//reminderRequest.setId(14);
		
		reminderEntry = new ReminderEntry();
		reminderEntry.setId(2);
		reminderEntry.setbSent(true);
		reminderEntry.setDay(new Date());
		reminderEntry.setSentDay(new Date());
		reminderEntry.setReminderRequest(reminderRequest);
		
	}
	
	@Test
	public void testAdd() {
		reminderRequestService.add(reminderRequest);
	}
	
	@Test
	public void testDeleteMember() {
		System.out.println("v = "  + reminderMemberMapper.delete(2));
	}
	@Test
	public void TestDeleteMember1() {
		reminderMemberMapper.deleteName (9, "we@cn.ibm.com");
	}
	@Test
	public void testSelect() {

		for (String o : reminderMemberMapper.get(5)) {
			System.out.println(o);
		}
	}
	@Test
	public void testSelect1(){

		System.out.println(reminderRequestMapper.getById(5));
	}
	@Test
	public void testSelect2() {
		System.out.println(reminderRequestService.getById(14));
	}
	
	@Test
	public void testDelete1() {
		reminderRequestService.delete(13);
	}
	@Test
	public void testUpdate1 () {
		reminderRequestMapper.update(reminderRequest);
	}
	@Test
	public void testUpdate2() {
		reminderRequestService.update(reminderRequest);
	}
	@Test
	public void testGetOwner1() {
		for (ReminderRequest o :reminderRequestService.getByOwner("jianjunw@cn.ibm.com")) {
			System.out.println(o);
		}
	}
	@Test
	public void testAddReminderEntry () {
		reminderEntryMapper.add(reminderEntry);
	}
	@Test
	public void testUpdateReminderEntry () {
		reminderEntryMapper.update(reminderEntry);
	}
	@Test
	public void testGetReminderEntryId() {
		System.out.println(reminderEntryMapper.getById(70));
	}
	@Test
	public void testGetReminderEntryRequestId() {
		System.out.println(reminderEntryMapper.getByRequestId(14));
	}
	@Test
	public void testSendMailService () {
		//sendMailService.sendReminderDaily();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllOfToday () {
		for (ReminderEntry o :reminderEntryService.getTodayReminders()) {
			System.out.println(o);
		}
	}
}
