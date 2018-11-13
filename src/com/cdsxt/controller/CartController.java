package com.cdsxt.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.ProductRo;
import com.cdsxt.ro.UserRo;
import com.cdsxt.service.RedisService;
import com.cdsxt.util.JsonUtil;
import com.cdsxt.vo.CartProductCountVo;
import com.cdsxt.vo.CookieVo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	//进入购物车页面
	@Autowired
	private RedisService redisService;
	@Test
	@RequestMapping("/query.do") 
	public String selectcart() throws Exception{
		UserRo user = (UserRo) ses.getAttribute("curUser");
		if(user==null){
		//未登陆时候显示的购物车页面
		String cookieValue = getCookieValue("name");
		if(cookieValue!=null){
			List<CookieVo> strToList = JsonUtil.jsonStrToList(cookieValue, CookieVo.class);
			req.setAttribute("strToList", strToList);
			
		}
		}
		//登陆时候显示的购物车页面
		if(user!=null){
			Integer userId = user.getUserId();
			Jedis jd=new Jedis("localhost", 6379);
			//可选：jd.auth("1111");
			jd.auth("1111");
			//b）通过连接jedis进行crud的操作
//			String hget = jd.hget("qwdsa","dsadsa");
			String hget = jd.hget("cart",userId+"");
			if(hget!=null){
				List<CookieVo> redisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
				CartProductCountVo statisInfo = redisService.statisCartProductInfo(redisList);
				req.setAttribute("strToList", redisList);
				req.setAttribute("statisInfo", statisInfo);
			}

			
			jd.close();
			
		}
		return "/page/front/cart.jsp";
	}

}
