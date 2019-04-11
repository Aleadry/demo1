package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class DemoController {
	@Autowired
	private BankService bank;
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "您的中商银行余额为:999,999,999,999,999。"+bank.aaaaaa();
	}
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "User !";
	}
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin !";
	}
	@PostMapping("/a")
	public String a() {
		return "A";
	}
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	@GetMapping("/log")
	@ResponseBody
	public String git() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		String username = ((UserDetails)principal).getUsername();
		return username;
		} else {
		String username = principal.toString();
		return username;
		}
	}
}
