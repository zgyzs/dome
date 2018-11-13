package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.ro.ProductRo;
import com.cdsxt.vo.CookieVo;

public interface ProductDao {

	List<ProductRo> selectHot();

	List<ProductRo> selectNew();

	ProductRo selectById(Integer pid,String ddd);
	//通过前端传来的id查询他的单价各种信息
	CookieVo SelectProduct(Integer pid);
	
	
	
}
