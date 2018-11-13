package com.cdsxt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdsxt.base.BaseController;
import com.cdsxt.ro.UserRo;
import com.cdsxt.service.ReceiveUserInfoService;
import com.cdsxt.service.RedisService;
import com.cdsxt.util.JsonUtil;
import com.cdsxt.vo.CartProductCountVo;
import com.cdsxt.vo.CookieVo;
import com.cdsxt.vo.PurchaseVo;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/redis")
public class RedisController extends BaseController {
	@Autowired
	private ReceiveUserInfoService receiveUserInfoService;
	@Autowired
	private RedisService redisService;
	@ResponseBody
	@RequestMapping("/updateRedis.do")
	public  String  updateRedis(@RequestBody List<CookieVo> order){
		//a）获取redis的连接jedis
		Jedis jd=new Jedis("localhost", 6379);
		//可选：jd.auth("1111");
		jd.auth("1111");
		//b）通过连接jedis进行crud的操作
//		String hget = jd.hget("qwdsa","dsadsa");
		UserRo user = (UserRo) ses.getAttribute("curUser");
		Integer userId = user.getUserId();
		String hget = jd.hget("cart",userId+"");
		//如果redis数据库有值
		if(hget!=null){
			List<CookieVo> jsonStrToRedisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
			for (int i = 0; i < order.size(); i++) {
				CookieVo curCookieVoFromCookie = order.get(i);
				Integer cookiepid = curCookieVoFromCookie.getPid();
				boolean isExsit = false;
				for (int j = 0; j < jsonStrToRedisList.size(); j++){
					CookieVo curCookieVoFromRedis = jsonStrToRedisList.get(j);
					Integer redispid = curCookieVoFromRedis.getPid();
					
					if(redispid.intValue()==cookiepid.intValue()){
						 Integer cookiepcount = curCookieVoFromRedis.getPcount();
						 Integer redispcount = curCookieVoFromCookie.getPcount()+cookiepcount;	
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
			 jd.close();
			 return "加入成功";
		}
		//如果redis数据库没有值
		if(hget==null){
			String objToJsonStr = JsonUtil.objToJsonStr(order);
			jd.hset("cart",user.getUserId()+"", objToJsonStr);
			jd.close();
			return "加入成功";
		}
		//c）关闭jedis连接
		jd.close();
		return "系统忙，添加失败，请稍后再试";
	}	
	
	
	//登陆后页面通过文本框改变数量
	@ResponseBody
	@RequestMapping("/updateRedisquantity.do")
	public  int  updateRedisquantity(Integer pid,Integer pcountValue){
			//得到当前用户信息
			UserRo curUser = getCurUser();
			//得到当前用户的id
			Integer userId = curUser.getUserId();
				//a）获取redis的连接jedis
				Jedis jd=new Jedis("localhost", 6379);
				//可选：jd.auth("1111");
				jd.auth("1111");
				//b）通过连接jedis进行crud的操作
				String hget = jd.hget("cart",userId+"");
				//把redis中的字符串转为list
				List<CookieVo> jsonStrToRedisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
				int RedisListsize = jsonStrToRedisList.size();
				for (int i = 0; i < RedisListsize; i++) {
					CookieVo cookieVo = jsonStrToRedisList.get(i);
					if(cookieVo.getPid()==pid){
						cookieVo.setPcount(pcountValue);
					}
				}
				//c）关闭jedis连接
				String objToJsonStr = JsonUtil.objToJsonStr(jsonStrToRedisList);
				 jd.hset("cart",userId+"", objToJsonStr);
				jd.close();
				return RedisListsize;
				
	}
	//删除购物车（redis）中数据
	@RequestMapping("/deleteRedispcs.do")
	public  void  deleteRedispcs(Integer pid){
		//得到当前用户信息
		UserRo curUser = getCurUser();
		//得到当前用户的id
		Integer userId = curUser.getUserId();
		Jedis jd=new Jedis("localhost", 6379);
		//可选：jd.auth("1111");
		jd.auth("1111");
		//b）通过连接jedis进行crud的操作
		String hget = jd.hget("cart",userId+"");
		List<CookieVo> jsonStrToRedisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
		int RedisListsize = jsonStrToRedisList.size();
		for (int i = 0; i < RedisListsize; i++) {
			CookieVo cookieVo = jsonStrToRedisList.get(i);
			if(cookieVo.getPid()==pid){
				jsonStrToRedisList.remove(cookieVo);
			}
		}
		String objToJsonStr = JsonUtil.objToJsonStr(jsonStrToRedisList);
		 jd.hset("cart",userId+"", objToJsonStr);
		jd.close();
		
		
	}
	//点击结算购物车时会把商品id与单个数量带上来
	@ResponseBody
	@RequestMapping("/accountShopping.do")
	public  String  accountShopping(@RequestBody List<PurchaseVo> orderLists){
		//点击结算购物车时会把商品id与单个数量带上来，
		//建立一个新的List用于装所有查到的商品信息
		List<CookieVo> strToList= new ArrayList<CookieVo>();
		for (int i = 0; i < orderLists.size(); i++) {
			//拿到当前商品的id
			Integer pid = orderLists.get(i).getId();
			//拿到当前商品的数量
			Integer num = orderLists.get(i).getNum();
			//通过当前id查询当前再数据库中的商品信息
			CookieVo cookieVo = productService.SelectProduct(pid);
			//把每个商品数量当前对象中
			cookieVo.setPcount(num);
			strToList.add(cookieVo);
		}
		//用所有查到的商品信息去查询总价，数量，种类
		CartProductCountVo statisInfo = redisService.statisCartProductInfo(strToList);
		//然后存入session作用域中
		ses.setAttribute("statisInfo", statisInfo);
		//拿当前登陆的用户
		UserRo curUser = getCurUser();
		//再拿他id，通过他id去他查他的收货人信息
		Integer userId = curUser.getUserId();
		List<Map<String, Object>> selectListByUserId = receiveUserInfoService.selectListByUserId(userId);
		
		//将所有收货人信息存入session作用域中
		ses.setAttribute("listReceiveUser", selectListByUserId);
		//将点击结算购物车的时候选中的商品全部存入session作用域中
		ses.setAttribute("strToList", strToList);
		return "/page/front/order.jsp";
	}
	
}
