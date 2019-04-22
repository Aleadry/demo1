package com.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.example.po.User;


public interface InsertUserDao {

	@Insert("insert into user(username,password,nickname) values(#{username},#{password},#{nickname})")
	public int insertUser(User user);
}