package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ConfigBean;

@RestController
public class HelloController {
	
	@Value("${my.name}")
	private String jak;
	@Value("${my.age}")
	private String age;
	@Value("${my.number}")
	private String number;
	@Value("${my.value}")
	private String value;
	@Autowired
	private ConfigBean conFig;

	@RequestMapping("/hello")
	public String stat() {
		return "Hello World"+","+jak+","+age+","+number+","+value;
	}
	@RequestMapping("/sayhello")
	public String star() {
		return "Hello World"+","+conFig.getName()+","+conFig.getAge()+","+conFig.getNumber()+","+conFig.getValue();
	}
	
	
	
}
