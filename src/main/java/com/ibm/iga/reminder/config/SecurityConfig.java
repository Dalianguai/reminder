package com.ibm.iga.reminder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ibm.iga.reminder.service.user.LoginAuthenticationProvider;
import com.ibm.iga.reminder.service.user.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, LoginAuthenticationProvider loginAuthenticationProvider, UserDetailsServiceImpl userDetailsService) throws Exception {
		auth.authenticationProvider(loginAuthenticationProvider);
		//auth.userDetailsService(userDetailsService);
		auth.eraseCredentials(false);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.antMatchers("/resources/**").permitAll()
					.antMatchers("/").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
					.anyRequest().authenticated()
				.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
					.logout()
						.permitAll()
						//.invalidateHttpSession(true)
				.and() 
					.httpBasic()
				.and()
					.csrf();
				//.and()
				//	.rememberMe();
		super.configure(http);
	}
	 
}
