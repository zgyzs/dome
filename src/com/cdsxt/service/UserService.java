package com.cdsxt.service;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.ro.UserRo;


@Service
public class UserService extends BaseService{

	public UserRo selectUserByName(String username){
		return userDao.selectUserByName(username);
	}
}
