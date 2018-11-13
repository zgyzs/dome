package com.cdsxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cdsxt.param.OrderParam;
import com.cdsxt.ro.OrderRo;
import com.cdsxt.ro.UserRo;
import com.cdsxt.vo.CartProductVo;

public interface OrderDao {
	
	//保存订单基本信息
	public void insertOrderInfo(@Param("orderRo")OrderRo orderRo);
	//保存订单商品列表信息
	public void insertOrderProductListInfo(CartProductVo[] proArr, String oid);
	//通过id查询订单信息
	public OrderRo selectById(String oid);
	
	//更改订单状态：通过原状态和订单id
	public void updateOrderState(String oid,String queryState,String setState);
	//通過用戶id查詢他下面的訂單
	public List<OrderRo> selectOrderRo(Integer userId);
	
}
