package com.cdsxt.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.vo.ReceiveVo;
@Service
public class ReceiveUserInfoService extends BaseService{
	
	public  List<Map<String, Object>> selectListByUserId(Integer userId){
		List<Map<String, Object>> selectListByUserId = receiveUserInfoDao.selectListByUserId(userId);
		
		return selectListByUserId;
	}
	public ReceiveVo selectById(Integer receiveUserId){
		ReceiveVo  selectById = receiveUserInfoDao.selectById(receiveUserId);
		
		return selectById;
	}
}
