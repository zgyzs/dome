package com.cdsxt.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.UserRo;
import com.cdsxt.util.CookieUtil;
import com.cdsxt.util.JsonUtil;
import com.cdsxt.vo.CookieVo;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	//
	@Autowired
	CartController cartController;
	
	/**
	 * 查看是否登录
	 */
	@RequestMapping("/isLogin.do")
	@ResponseBody
	public String isLogin(){
		if(super.getCurUser()==null){
			return "{\"isLogin\":false}";
		}
		return "{\"isLogin\":true}";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("/login.do")
	public String login(String username,String password)throws Exception{
		//去查询数据
		UserRo user=userService.selectUserByName(username);		
		if (user!=null&&user.getPwd().equals(password)) {
			//登录成功
			//设置用户类型
			Cookie cookie1=new Cookie("disembark", "1");
			cookie1.setPath("/");
			resp.addCookie(cookie1);
			String cookieValue = getCookieValue("name");
			//判断当前用户再在未登陆之前是否添加的购物车 如何有进去处理
			if(cookieValue!=null){
			//把cookie里面的购物车信息转为list的东西
			Jedis jd=new Jedis("localhost", 6379);
			//可选：jd.auth("1111");
			jd.auth("1111");
			//b）通过连接jedis进行crud的操作
			String hget = jd.hget("cart",user.getUserId()+"");
			//判断redis中有无当前用户的购物车，如果没有则把从cookie中取出的购物车字符串加入redis中，并清楚cookie的订单
			if(hget==null){
			 jd.hset("cart",user.getUserId()+"", cookieValue);
			 deleteCookie("name");
			}else{
				//判断redis中有无当前用户的购物车，如果有则把从cookie中取出的购物车字符串转换list对象
				List<CookieVo> jsonStrToList = JsonUtil.jsonStrToList(cookieValue, CookieVo.class);
				//把redis中的字符串也取出来与Cookie中购物车比较，如果有订单相同的则二个数量相加，且如果cookie里面的订单有redis中没有的则加入
				List<CookieVo> jsonStrToRedisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
				for (int i = 0; i < jsonStrToList.size(); i++) {
					CookieVo curCookieVoFromCookie = jsonStrToList.get(i);
					Integer cookiepid = curCookieVoFromCookie.getPid();
					boolean isExsit = false;
					for (int j = 0; j < jsonStrToRedisList.size(); j++){
						CookieVo curCookieVoFromRedis = jsonStrToRedisList.get(j);
						Integer redispid = curCookieVoFromRedis.getPid();
						
						if(redispid.intValue()==cookiepid.intValue()){
							 Integer cookiepcount = curCookieVoFromRedis.getPcount();
							 Integer redispcount = curCookieVoFromRedis.getPcount()+cookiepcount;	
							 curCookieVoFromRedis.setPcount(redispcount);
							 isExsit = true;
							 continue;
						}
					}
					if(!isExsit){
						jsonStrToRedisList.add(curCookieVoFromCookie);
					}
					
				}
				String objToJsonStr = JsonUtil.objToJsonStr(jsonStrToRedisList);
				 jd.hset("cart",user.getUserId()+"", objToJsonStr);
				 deleteCookie("name");
			}
			//c）关闭jedis连接
			jd.close();
			}
			super.ses.setAttribute("curUser", user);
			//合并购物车（把cookie的数据推入到redis中=删除cookie的数据）
//			cartController.cookieMergeToRedis();
			//去主页
			return "/index/query.do";
		}
		//登录失败：用户名或密码错误
		return "/page/front/login.jsp";
	}
	
	/**
	 * 注销
	 */
	@RequestMapping("/loginOut.do")
	public String loginOut(){
		deleteCookie("disembark");
		//删除sesison用户
		ses.removeAttribute("curUser");
		//回主页
		return "redirect:/index/query.do";		
	}
}
