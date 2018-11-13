package com.cdsxt.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.CategoryRo;
import com.cdsxt.ro.ProductRo;

/**
 * 首页的控制器
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController{
	
	
	/**
	 * 查看首页的数据-并转发到jsp页面
	 */
	@RequestMapping("/query.do")
	public String query(){
//		TestCookieController.printCookie(req);
		//--一定时间刷新一次
		ServletContext sc=super.req.getServletContext();
		if (sc.getAttribute("catList")==null) {
			List<CategoryRo> catList= categoryService.selectAll();
			sc.setAttribute("catList", catList);
		}
		List<ProductRo> hotProList= productService.selectHot();
		req.setAttribute("hotProList", hotProList);
		List<ProductRo> newProList= productService.selectNew();
		req.setAttribute("newProList", newProList);
		
		//转发到jsp中
		return "/page/front/index.jsp";
	}
}
