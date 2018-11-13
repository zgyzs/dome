package com.cdsxt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.ro.ProductRo;
import com.cdsxt.vo.CookieVo;


@Service
public class ProductService extends BaseService{

	public  List<ProductRo> selectHot(){
		return productDao.selectHot(); 
	}

	public List<ProductRo> selectNew(){
		return productDao.selectNew();
	}

	public ProductRo selectById(Integer pid,String ddd){
		return productDao.selectById(pid, ddd);
	}
	//通过前端传来的id查询他的单价各种信息
	public CookieVo SelectProduct(Integer pid){
		return productDao.SelectProduct(pid);
	}
	
}
