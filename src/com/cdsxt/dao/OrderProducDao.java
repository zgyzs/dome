package com.cdsxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cdsxt.ro.OrderProducRo;


public interface OrderProducDao {
	public void insertOrderProducRo(@Param("orderProducRoList")List<OrderProducRo> orderProducRoList);
	
}
