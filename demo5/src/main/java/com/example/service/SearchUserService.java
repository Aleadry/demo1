package com.example.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.po.User;

@Service
public interface SearchUserService {

	int searchUserNum(User user);
	List<User> searchUser();
}
