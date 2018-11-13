package com.cdsxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsxt.dao.OrderDao;
import com.cdsxt.ro.OrderRo;

@Service
public class OrderRoService {
	@Autowired
	private OrderDao orderDao;
	//保存订单基本信息
	public void insertOrderInfo(OrderRo orderRo){
		orderDao.insertOrderInfo(orderRo);
	}
	//通過用戶id查詢他下面的訂單
	public List<OrderRo> selectOrderRo(Integer userId){
		List<OrderRo> selectOrderRo = orderDao.selectOrderRo(userId);
		return selectOrderRo;
		
	}
	//更改订单状态：通过原状态和订单id
		public void updateOrderState(String oid,String queryState,String setState){
			orderDao.updateOrderState(oid, queryState, setState);
		}
}
