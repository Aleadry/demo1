package com.example.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.po.User;
import com.example.serviceimpl.InsertUserImpl;
import com.example.serviceimpl.SearchUserImpl;

@Controller
public class RegisterController {

	@Autowired
	public InsertUserImpl inUser;
	@Autowired
	public SearchUserImpl seUser;
	@RequestMapping("/registerC")
	public String InsertUser(User user,Locale locale,BindingResult result){
		ResourceBundle myResources =
                ResourceBundle.getBundle("message", locale);
		if(user.getUsername()=="") {
			FieldError error=new FieldError("user","username",myResources.getString("errorUserName"));
			result.addError(error);
			return  "Register";
		}
		if(user.getPassword()=="") {
			FieldError error=new FieldError("user","password",myResources.getString("errorPassWord"));
			result.addError(error);
			return  "Register";
		}
		int flag=0;
		flag=seUser.searchUserNum(user);
		if(flag!=0) {
			return "Register";			
		}else {
			flag=inUser.insertUserService(user);
			if(flag==0) {
				return "Register";	
			}
			return "Login";
		}
	}
}
