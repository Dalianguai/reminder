package com.ibm.iga.reminder.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ibm.iga.reminder.config.RootConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={RootConfiguration.class})
public class TestCalendar {

	
	@Test
	public void testDate () {
		Date startDay = new Date();
		Calendar cStartDay = new GregorianCalendar();
		cStartDay.setTime(startDay);
		//cStartDay.add(Calendar.DATE, 1);
		Calendar endDay = new GregorianCalendar();
		endDay.setTime(new Date());
		System.out.println(new Date() + "," + cStartDay.getTime() + "," + endDay.get(Calendar.DATE));
		System.out.println(cStartDay.compareTo(endDay));
		
		
		int dayOfMonth = cStartDay.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cStartDay.get(Calendar.DAY_OF_WEEK);
		int weekOfMonth = cStartDay.get(Calendar.WEEK_OF_MONTH);
		
		System.out.println(dayOfMonth +"," + dayOfWeek +"," + weekOfMonth);
		//cStartDay
	}
}
