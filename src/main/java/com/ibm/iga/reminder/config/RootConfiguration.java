package com.ibm.iga.reminder.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//spring config
@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
//@Import(value = {MyBatisConfig.class, MailConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = {"com.ibm.iga.reminder.config", "com.ibm.iga.reminder.service", "com.ibm.iga.reminder.dao", "com.ibm.iga.reminder.aspectj", "com.ibm.iga.reminder.scheduling", "com.ibm.iga.reminder.filter"})
public class RootConfiguration {

}
