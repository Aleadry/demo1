package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class Demo2Application {

	public static void main(String[] args) {	
		SpringApplication.run(Demo2Application.class, args);
		
	}
	@Bean
	public static CommandLineRunner testA() {
		CommandLineRunner runner= new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("The System runner start to init ......");
				
			}
		};
		return runner;
	}
	@Bean
	public ApplicationRunner appRunner() {
		return args->{
			System.out.println("--Application Runner--");
			for(String opt:args.getOptionNames()) {
				System.out.print(opt);
				System.out.print("->");
				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",",",","]")));
			}
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener(){
		final String hello_URL="/hello";
		return (ApplicationEvent even)->{
			if(even instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e=(ServletRequestHandledEvent) even;
				if(e.getRequestUrl().equals(hello_URL)) {
					System.out.println("visit hello");
				}
			}
		};
	}
}
