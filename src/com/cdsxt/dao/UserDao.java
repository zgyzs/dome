package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.ro.UserRo;

public interface UserDao {
	//查询用户
	public UserRo selectUserByName(String username);
	//查询用户列表
	List<UserRo> selectAll();
}
