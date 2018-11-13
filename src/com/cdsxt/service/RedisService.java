package com.cdsxt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.vo.CartProductCountVo;
import com.cdsxt.vo.CookieVo;
@Service
public class RedisService extends BaseService{
	/**
	 * 计算商品统计信息的功能==
	 * 
	 * @param cpArr  要计算的购物车的商品
	 * @param isDbSumPrice  是否取数据库查询商品总价
	 * @return 计算的结果
	 */
	public CartProductCountVo statisCartProductInfo(List<CookieVo> redisList){
		//总价
		int countPrice=0;
		//总分类数量
		int countCate=0;
		//总商品数量
		int countPcount=0;
		for (CookieVo cp : redisList) {
			countCate++;
			countPcount+=cp.getPcount();
			//判断：拿购物车的商品价格，拿mysql价格
			int sumPrice;
			sumPrice=cp.getPprice();
			countPrice+=(cp.getPcount()*sumPrice);
		}
		return new CartProductCountVo(countPrice, countCate, countPcount);
	}
	
}
