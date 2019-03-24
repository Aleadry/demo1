package cn.com.taiji.control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.po.HelloWorld;

@Configuration
public class ControlType {
	
	@Bean
	public HelloWorld helloWorld() {
		HelloWorld helloWorld=new HelloWorld();
		helloWorld.setName("李红");
		return helloWorld;	
	}
}