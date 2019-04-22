package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.po.User;

@Controller
public class HtmlController {

	@RequestMapping("/register")
	public String register(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "Register";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "Login";
	}
}
