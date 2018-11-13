package com.cdsxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsxt.dao.OrderDao;
import com.cdsxt.dao.OrderProducDao;
import com.cdsxt.ro.OrderProducRo;
import com.cdsxt.ro.OrderRo;

@Service
public class OrderProducService {
	@Autowired
	private OrderProducDao orderProducDao;
	public void OrderProducDao(List<OrderProducRo> orderProducRoList){
		orderProducDao.insertOrderProducRo(orderProducRoList);
	}
}
