package com.ibm.iga.reminder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;

@Configuration
public class MailConfig {
	@Bean(name = "mailSender")
	public SendGrid getSendGrid(){
		SendGrid sendGrid = new SendGrid("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");
		return sendGrid;
	}
	
	@Bean(name = "email")
	public SendGrid.Email getEmail () {
		SendGrid.Email email = new Email();
		email.setFrom("noreply@reminder.you.com");
		email.setSubject("[Reminder]");
		email.setText("\n\n\n PLEASE DO NOT REPLY THE MAIL, ANY QUESTION, CONTACT jianjunw@cn.ibm.com please.");
		return email;
	}
}
