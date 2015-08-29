package com.ibm.iga.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.iga.reminder.dao.ReminderUserMapper;
import com.ibm.iga.reminder.model.ReminderUserDetails;
import com.ibm.iga.reminder.service.inter.ISendUserService;
import com.ibm.iga.reminder.service.inter.IUserService;

public class UserService implements IUserService {

	@Autowired
	private ReminderUserMapper reminderUserMapper;
	
	@Autowired
	private ISendUserService sendUserService;
	
	@Override
	public void register(ReminderUserDetails user) {
		reminderUserMapper.addUser(user);
		reminderUserMapper.addUserRole(user);
		sendUserService.sendUserRegistrationMail(user);
	}

	@Override
	public void updatePassword(ReminderUserDetails user) {
		reminderUserMapper.updatePassword(user);
		sendUserService.sendUserUpdatePasswordMail(user);
	}

	@Override
	public void forgotPassword(ReminderUserDetails user) {
		sendUserService.sendUserForgotPasswordMail(user);
	}

}
