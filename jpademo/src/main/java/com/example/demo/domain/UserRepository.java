package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User>,PagingAndSortingRepository<User,String>{

	public List<User> findByFlagOrderByIdAsc(@Param("flag") int i);
	public List<User> findByFlagAndUsernameOrderByIdAsc(@Param("flag") int i,@Param("username") String username);
}
