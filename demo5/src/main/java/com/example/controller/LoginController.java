package com.example.controller;


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.po.User;
import com.example.serviceimpl.SearchUserImpl;
@Controller
public class LoginController {

	@Autowired
	public SearchUserImpl seUser;
	public int SearchUser(HttpServletRequest request,User user){
		int uid=0;
		uid=seUser.searchUserNum(user);
		request.getSession().setAttribute("user", uid);
		return uid;
	}
	@PostMapping("/submit")
	public String submit(@Validated User user,BindingResult result,Model model,HttpServletRequest request,Model model1,Locale locale) {
		ResourceBundle myResources =
                ResourceBundle.getBundle("message", locale);
		if(user.getUsername()=="") {
			FieldError error=new FieldError("user","username",myResources.getString("errorUserName"));
			result.addError(error);
			return  "Login";
		}
		if(user.getPassword()=="") {
			FieldError error=new FieldError("user","password",myResources.getString("errorPassWord"));
			result.addError(error);
			return  "Login";
		}
		if(result.hasErrors()) {
			return "Login";
		}
		int uuid=SearchUser( request, user);
		if(uuid==0) {
			return "Login";
		}else {
			List<User> userlist=seUser.searchUser();
			model1.addAttribute("userlist",userlist);
			return "menu";
		}
	}
}
