package com.example.demo.config;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.example.demo.controller.LogoutController;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		return manager;
	}
	@Autowired
	private DataSource dataSource;
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasRole("USER")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.successForwardUrl("/a")
			.permitAll()
			.and()
		.csrf().disable()
		.headers().frameOptions().sameOrigin().and()
		.logout()
			.logoutUrl("/my/logout")   
			.logoutSuccessHandler(new LogoutController())
			.addLogoutHandler(new LogoutHandler() {
				@Override
				public void logout(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) {
					// TODO Auto-generated method stub
					System.out.println("我执行了");
					try {
						response.getWriter().write("oh ha you!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			})
			.deleteCookies("aaaaaaaa")
			.invalidateHttpSession(true);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("1").password("1").roles("USER")
        .and().withUser("2").password("2").roles( "ADMIN")
        .and().withUser("3").password("3").roles( "DBA")
        .and().withUser("4").password("4").roles( "ADMIN", "DBA");*/
		auth
		.jdbcAuthentication()
			.dataSource(dataSource);
//			.withDefaultSchema()
//			.withUser("1").password("1").roles("USER").and()
//			.withUser("2").password("2").roles("USER", "ADMIN");
	}

}