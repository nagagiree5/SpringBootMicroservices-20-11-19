package com.pack.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder  encoder;
	
	@Bean
	public   BCryptPasswordEncoder  encode() {
		return   new  BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 //.antMatchers("/delete**", "/save**","/index**","/update**","/listEmployees")
		 //.antMatchers("/**")
		.antMatchers("/delete**","/save**")
		.hasAnyRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/doLogin")
		.failureUrl("/login?msg=Bad Credentials")        
        .and()
        .rememberMe().key("uniqueAndSecret")
		.and().exceptionHandling().accessDeniedPage("/accessDenied")
		.and().exceptionHandling().accessDeniedPage("/405")
		.and().logout().logoutUrl("/logoutuser").logoutSuccessUrl("/loggedout").permitAll()
		.and()   
		.csrf().disable();
		http.sessionManagement().maximumSessions(1); 
		//http.requiresChannel().anyRequest().requiresSecure();
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource())
		 .usersByUsernameQuery("select username, password, enabled"
		            + " from users where username=?")
		        .authoritiesByUsernameQuery("select username, authority "
		            + "from authorities where username=?")
		        .passwordEncoder(encoder);
	}
	@Bean
    public  DataSource   dataSource() {
	DriverManagerDataSource   ds =new  DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/test");
	ds.setUsername("root");
	ds.setPassword("root");
	return ds;
	}
}