package com.ibm.iga.reminder.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Jerry Wang
 * 
 * /api/user/register -- post to create new account
 *  /api/user/password/update -- post to update password
 *  /api/user/password/forgot -- post to receive mail with current password
 *
 */
@RestController
@RequestMapping("/api/user")
public class RestRegister {

}
