package com.learn.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learn.repository.UserRepositoryImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //only when method level  @PreAuthorize annotation used.
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(getProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
       System.out.println("## Inside the configure(HttpSecurity http)  method ##");
		
		http.csrf().disable()
			 .authorizeRequests()
			 .antMatchers("/h2-console/**","/api/v1/students/hi**").permitAll()
		//	 .antMatchers(HttpMethod.GET).hasAnyRole("USER","CREATOR","ADMIN","EDITOR")
		//	 .antMatchers(HttpMethod.POST).hasAnyRole("CREATOR","ADMIN")
		//	 .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","EDITOR")
		//	 .antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().
			 and()
			.httpBasic();
		
		http.headers().frameOptions().disable();// if not mention this h2-console will not open.
	}
	
	@Bean
	public DaoAuthenticationProvider getProvider() {
		
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(userRepositoryImpl);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return   new BCryptPasswordEncoder(10);
	}

	
	
}
