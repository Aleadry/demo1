package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest request,String username,String password) {
		if("admin".equals(username)) {
			if("123456".equals(password)) {
				request.getSession().setAttribute("user", "1");
				return "Admin Login Success!";
			}
		}
		if("user".equals(username)) {
			if("123456".equals(password)) {
				request.getSession().setAttribute("user", "2");
				return "User Login Success!";
			}
		}
		return "Login Failed!";
	}
}
