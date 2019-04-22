package com.example.serviceimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.InsertUserDao;
import com.example.po.User;
import com.example.service.InsertUserService;

@Service
public class InsertUserImpl implements InsertUserService{

	@Autowired
	private InsertUserDao userDao;
	@Override
	public int insertUserService(User user) {
		// TODO Auto-generated method stub
		int flag=userDao.insertUser(user);
		return flag;
	}

	
}
