package com.casestudy.APIGateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.casestudy.APIGateway.Service.MyUsersDetailService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUsersDetailService myUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	/*
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests()
	 * 
	 * .antMatchers("/api-payment/**").hasAnyRole("Customer")
	 * .antMatchers("/api-customer/**").hasAnyRole("Customer","Admin")
	 * .antMatchers("/api-dealer/**").hasAnyRole("Dealer","Admin")
	 * .antMatchers("/api-delivery/**").hasAnyRole("Delivery","Admin")
	 * .antMatchers("/api-cart/**").hasAnyRole("Customer","Admin")
	 * .antMatchers("/api-order/**").hasAnyRole("Delivery","Customer","Dealer",
	 * "Admin") .antMatchers("/api-delivery/**").hasAnyRole("Delivery","Admin")
	 * 
	 * .antMatchers("api-product/product/getall").permitAll()
	 * .antMatchers("/**").hasAnyRole() .and().formLogin();
	 * 
	 * }
	 */
	
	@Override public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/api-product/product/getall").permitAll().
		 anyRequest().authenticated().and().formLogin();
		 }
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
