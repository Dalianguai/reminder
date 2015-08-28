package com.ibm.iga.reminder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jerry Wang
 *
 */
@Repository
public interface ReminderMemberMapper {
	@Insert("insert into reminder_member (request_id, name) values (#{request_id}, #{memberName}) ")
	public long add (@Param("request_id") long request_id, @Param("memberName") String memberName);
	
	@Delete("delete from reminder_member where request_id = #{id}")
	public long delete (long id);//this will delete all rows/members of that request_id
	
	@Delete("delete from reminder_member where id = #{id} and name = #{name}")
	public long deleteName (@Param("id") long id, @Param("name") String name);
	
	@Select("select name from reminder_member where request_id =#{id}")
	public List<String> get (long id);
}
