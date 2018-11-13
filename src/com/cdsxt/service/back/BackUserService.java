package com.cdsxt.service.back;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.ro.UserRo;

@Service
public class BackUserService extends BaseService{
	//查询用户
	public UserRo selectUserByName(String username){
		return backUserDao.selectUserByName(username);
	}
	//查询用户列表
	public List<UserRo> selectAll(){
		return backUserDao.selectAll();
	}
}
