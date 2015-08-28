package com.ibm.iga.reminder.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private static long t = 0;

    @Pointcut("execution(* com.ibm.iga.reminder.service.ReminderRequestService.get*(..))")
	//@Pointcut("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcutExpression() {   } 
    
    @Before("pointcutExpression()")  
    public void beforeMethod(JoinPoint joinPoint) {  
        System.out.println("It has been called " + t++ +" times.");  
        
    }  
}
