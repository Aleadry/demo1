package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "您的中商银行余额为:999,999,999,999,999。";
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

}
