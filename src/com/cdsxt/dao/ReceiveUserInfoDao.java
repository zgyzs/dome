package com.cdsxt.dao;

import java.util.List;
import java.util.Map;

import com.cdsxt.ro.UserRo;
import com.cdsxt.vo.ReceiveVo;

public interface ReceiveUserInfoDao {
	//查询收货人信息列表
	List<Map<String, Object>> selectListByUserId(Integer userId);
	//通过id查询收货人信息
	ReceiveVo selectById(Integer receiveUserId);
}
