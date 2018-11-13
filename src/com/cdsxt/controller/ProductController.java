package com.cdsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.ProductRo;

/**
 * 产品页
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	
	/**
	 * 查看首页的数据-并转发到jsp页面
	 */
	@RequestMapping("/selectById.do") 
	public String selectById(Integer pid){
//		TestCookieController.printCookie(req);
		//查询商品详细信息
		ProductRo pro= productService.selectById(pid,"11");
		//放入req
		req.setAttribute("curProduct", pro);
		//转发到jsp中
		return "/page/front/product.jsp";
	}
}
