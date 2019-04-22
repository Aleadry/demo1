package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.po.User;

@Repository
public interface SelectUserDao {

	@Select("select count(*) from user u where u.username=#{username} and u.password=#{password}")
	public int selectUserNum(User user);
	@Select("select * from user")
	public List<User> selectUser();
	
}
