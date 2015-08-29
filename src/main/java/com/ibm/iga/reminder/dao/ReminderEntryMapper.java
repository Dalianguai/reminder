package com.ibm.iga.reminder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ibm.iga.reminder.model.ReminderEntry;
import com.ibm.iga.reminder.model.ReminderRequest;
/**
 * 
 * @author Chengxiao
 *
 */
@Repository
public interface ReminderEntryMapper {
	
	@Insert("insert into reminder_entry (request_id, day, bSent , sentDay) "
			+ "values (#{reminderRequest.id}, #{day}, #{bSent}, #{sentDay})")
	@SelectKey(before = false, keyProperty = "id", resultType = java.lang.Integer.class, statement = { "select last_insert_id() as id" })
	public long add(ReminderEntry reminderEntry);
	
	@Update("update reminder_entry set bSent = #{bSent}, sentDay = #{sentDay} where id = #{id}")
	public long update(ReminderEntry reminderEntry);
	
	@Delete("delete from reminder_entry where id = #{id}")
	public long delete (long id);
	
	@Delete("delete from reminder_entry where request_id = #{id}")
	public long deleteByRequestId(long id);
	
	@Select("select id, request_id, day, bSent, sentDay from reminder_entry where id= #{id} ")
	@Results(
			@Result(property="reminderRequest", column="request_id", javaType=ReminderRequest.class,
			one = @One(select = "com.ibm.iga.reminder.dao.ReminderRequestMapper.getById"))
			)
	public ReminderEntry getById(long id);
	
	@Select("select id, request_id, day, bSent, sentDay from reminder_entry where request_id = #{id}")
	@Results(
			@Result(property="reminderRequest", column="request_id", javaType=ReminderRequest.class,
			one = @One(select = "com.ibm.iga.reminder.dao.ReminderRequestMapper.getById"))
			)
	public List<ReminderEntry> getByRequestId(long id);
	
	
	@Select("select id, request_id, day, bSent, sentDay from reminder_entry where day <= CURDATE() and bSent = 0")
	@Results(
			@Result(property="reminderRequest", column="request_id", javaType=ReminderRequest.class,
			one = @One(select = "com.ibm.iga.reminder.dao.ReminderRequestMapper.getById"))
			)
	public List<ReminderEntry> getTodayReminderEntries ();
	
}
