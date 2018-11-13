package com.cdsxt.base;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdsxt.ro.UserRo;
//import com.cdsxt.service.CartService;
import com.cdsxt.service.CategoryService;
//import com.cdsxt.service.OrderService;
import com.cdsxt.service.ProductService;
import com.cdsxt.service.UserService;
import com.cdsxt.service.back.BackUserService;

public abstract class BaseController {
	/**
	 * 服务器对象
	 */
	@Autowired
	protected HttpSession ses;
	@Autowired
	protected HttpServletRequest req;
	@Autowired
	protected HttpServletResponse resp;
	/**
	 * 业务对象
	 */
/*	@Autowired
	protected OrderService  orderService;*/
//
//	@Autowired
//	protected CartService cartService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected ProductService productService;
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected BackUserService backUserService; 

	
	/**
	 * 通用功能
	 */
	//获取当前用户信息
	public UserRo getCurUser(){
		UserRo user= (UserRo) this.ses.getAttribute("curUser");
		return user;
	}
	
	/**
	 * 获取指定cookie的name的val的功能
	 * 并对cookie的值进行url解码
	 */
	public  String getCookieValue(String cookieName) throws Exception{
		
		Cookie[] cookieArr=this.req.getCookies();
		//cookie的值
		String cookieVal=null;
		for (Cookie cookie : cookieArr) {
			if (cookieName.equals(cookie.getName())) {
				cookieVal=cookie.getValue();
				//解码
				cookieVal= URLDecoder.decode(cookieVal, "utf-8");
				
				return cookieVal;
			}
		}
		//找不到对应值返回null
		return null;
	}
	
	
	/**
	 * 删除cookie
	 * @param req
	 * @param resp
	 * @param cookieName
	 */
	public  void deleteCookie(String cookieName){
		Cookie[] cookieArr=this.req.getCookies();
		
		for (Cookie cookie : cookieArr) {
			if (cookieName.equals(cookie.getName())) {
				/**
				 * 注意！新建cookie对象进行删除
				 */
				//删除cookie
				Cookie ck=new Cookie(cookieName, cookie.getValue());
				ck.setMaxAge(0);
				ck.setPath("/");
				//通过resp对象设置到输出的cookie中
				this.resp.addCookie(ck);
				return;
			}
		}
	}
	
}
