package com.cdsxt.dao.back;

import java.util.List;

import com.cdsxt.ro.UserRo;

public interface BackUserDao {
	//查询用户
	public UserRo selectUserByName(String username);
	//查询用户列表
	List<UserRo> selectAll();
}
