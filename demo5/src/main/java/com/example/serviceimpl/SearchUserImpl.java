package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SelectUserDao;
import com.example.po.User;
import com.example.service.SearchUserService;

@Service
public class SearchUserImpl implements SearchUserService{

	@Autowired
	private SelectUserDao userDao;
	@Override
	public int searchUserNum(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		// TODO Auto-generated method stub
		int flag=0;
		flag=userDao.selectUserNum(user);
		System.out.println(flag);
		return flag;
	}
	@Override
	public List<User> searchUser() {
		// TODO Auto-generated method stub
		List<User> list=null;
		list=userDao.selectUser();
		return list;
	}

}
