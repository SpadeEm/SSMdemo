package com.java.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.java.entity.User;

@Repository
public interface UserDao {
	
	public User login(@Param("userName")String userName,@Param("userPassword")String userPassword);
}
