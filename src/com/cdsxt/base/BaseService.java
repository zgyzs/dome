package com.cdsxt.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdsxt.dao.CategoryDao;
import com.cdsxt.dao.OrderDao;
import com.cdsxt.dao.ProductDao;
import com.cdsxt.dao.ReceiveUserInfoDao;
import com.cdsxt.dao.UserDao;
import com.cdsxt.dao.back.BackUserDao;

public abstract class BaseService {
	
	/**
	 * 业务对象
	 */
	@Autowired
	protected ProductDao  productDao;
	@Autowired
	protected CategoryDao  categoryDao;
	@Autowired
	protected UserDao  userDao;
	@Autowired
	protected BackUserDao backUserDao;
	
	@Autowired
	protected ReceiveUserInfoDao receiveUserInfoDao;
	
	@Autowired
	protected OrderDao orderDao;
	
	
}
