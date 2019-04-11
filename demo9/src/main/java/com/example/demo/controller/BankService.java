package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;


@Component
public class BankService {

	@Secured("role_user")
    public String aaaaaa() {
        return "我是被保护的方法";
    }
	
}
