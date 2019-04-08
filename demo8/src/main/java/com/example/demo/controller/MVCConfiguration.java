package com.example.demo.controller;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.Interceptor.FilterA;
import com.example.demo.Interceptor.FilterB;
import com.example.demo.Interceptor.FilterC;

@Configuration
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	@Order(1)
	public FilterRegistrationBean addFilterC() {
		FilterRegistrationBean filter=new FilterRegistrationBean();
		filter.setFilter(new FilterC());
		filter.addUrlPatterns("/loginout");
		return filter;
	}
	@Bean
	@Order(2)
	public FilterRegistrationBean addFilterA() {
		FilterRegistrationBean filter=new FilterRegistrationBean();
		filter.setFilter(new FilterA());
		filter.addUrlPatterns("/*");
		return filter;
	}
	@Bean
	@Order(3)
	public FilterRegistrationBean addFilterB() {
		FilterRegistrationBean filter=new FilterRegistrationBean();
		filter.setFilter(new FilterB());
		filter.addUrlPatterns("/adf","/zxc");
		return filter;
	}
	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new InterceptorA());
		super.addInterceptors(registry);
	}*/
	
}
