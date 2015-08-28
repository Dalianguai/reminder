package com.ibm.iga.reminder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;









import com.ibm.iga.reminder.model.ReminderRequest;

/**
 * 
 * @author Jerry Wang
 *
 */

@Repository
public interface ReminderRequestMapper {

	@Insert("insert into reminder_request (owner, subject, description, rep, daily, weekly, monthlyByDay, monthlyByDate, day, startDay, endDay, createDate) "
			+ " values (#{owner}, #{subject}, #{description}, #{repeat}, #{daily}, #{weekly}, #{monthlyByDay}, #{monthlyByDate}, #{day}, #{startDay}, #{endDay}, #{createDate})")
	@SelectKey(before = false, keyProperty = "id", resultType = java.lang.Integer.class, statement = { "select last_insert_id() as id" })
	public long add(ReminderRequest request);
	
	@Update("update reminder_request set owner = #{owner}, subject = #{subject}, description = #{description}, rep = #{repeat}, daily = #{daily},"
			+ "weekly = #{weekly}, monthlyByDay = #{monthlyByDay}, monthlyByDate = #{monthlyByDate}, day = #{day}, startDay = #{startDay},"
			+ "endDay = #{endDay} where id = #{id}")
	public long update(ReminderRequest request);
	
	@Delete("delete from reminder_request where id = #{id}")
	public long delete (long id);
	
	@Select("select id, owner, subject, description, rep, daily, weekly, monthlyByDay, monthlyByDate, day, startDay, endDay, createDate from reminder_request where id= #{id} ")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="repeat",column="rep"),
			@Result(property="members",column="id", javaType=List.class,
			many = @Many(select = "com.ibm.iga.reminder.dao.ReminderMemberMapper.get")
			)}
	)
	public ReminderRequest getById (long id);
		
	@Select("select id, owner, subject, description, rep, daily, weekly, monthlyByDay, monthlyByDate, day, startDay, endDay, createDate from reminder_request where owner = #{owner}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="repeat",column="rep"),
			@Result(property="members",column="id", javaType=List.class,
			many = @Many(select = "com.ibm.iga.reminder.dao.ReminderMemberMapper.get")
			)}
	)
	public List<ReminderRequest> getByOwner (String owner);
	
}
