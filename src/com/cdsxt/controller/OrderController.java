package com.cdsxt.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cdsxt.base.AlipayConfig;
import com.cdsxt.base.BaseController;
import com.cdsxt.ro.OrderProducRo;
import com.cdsxt.ro.OrderRo;
import com.cdsxt.ro.UserRo;
import com.cdsxt.service.OrderProducService;
import com.cdsxt.service.OrderRoService;
import com.cdsxt.service.ReceiveUserInfoService;
import com.cdsxt.util.JsonUtil;
import com.cdsxt.vo.CartProductCountVo;
import com.cdsxt.vo.CookieVo;
import com.cdsxt.vo.ReceiveVo;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Autowired
	private OrderRoService orderRoService;
	@Autowired
	private OrderProducService orderProducService;
	@Autowired
	private ReceiveUserInfoService receiveUserInfoService;
	//进入订单页面
	@RequestMapping("/query.do")
	public String query(Integer id){
		 UserRo curUser = getCurUser();
		 //獲取當前登陸的用戶id
		 Integer userId = curUser.getUserId();
		 List<OrderRo> orderList = orderRoService.selectOrderRo(userId);
			 req.setAttribute("orderList", orderList);
			 return "/page/front/orderUser.jsp";
	}
	
	
	
	//调用支付宝接口
	public String result(String oid,Integer sumPrice){
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		String name="早点睡";
		String describe="有精神";
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no=null;
		String total_amount=null;
		String subject=null;
		String body =null;
		try {
			out_trade_no = new String(oid.getBytes("ISO-8859-1"),"UTF-8");
			total_amount = new String((sumPrice+"").getBytes("ISO-8859-1"),"UTF-8");
			//订单名称，必填
			subject= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			//商品描述，可空
			body = new String(describe.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//付款金额，必填
		
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String result=null;
		try {
			 result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	@Transactional
	@ResponseBody
	@RequestMapping("/createOrderandProduct.do")
	public String createOrderandProduct(Integer id){
		//拿到主键uuid
		String oid = UUID.randomUUID().toString();
		//传进来的参数是收货人的id，通过id去查当前收货人信息
		 ReceiveVo selectById = receiveUserInfoService.selectById(id);
		 //拿儅收貨人名字
		 String name = selectById.getName();
		 //收貨人電話
		 String phone = selectById.getPhone();
		 //收貨人地址
		 String addr = selectById.getAddr();
		 //之前商品的數量，總價，種類
		 CartProductCountVo statisInfo= (CartProductCountVo) ses.getAttribute("statisInfo");
		 //拿到總價
		 Integer sumPrice = statisInfo.getCountPrice();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 //獲取當前時間
		 Date format = new Date();
		 UserRo curUser = getCurUser();
		 //獲取當前登陸的用戶id
		 Integer userId = curUser.getUserId();
		 //吧訂單的信息全部存入OrderRo對象中
		 OrderRo order = new OrderRo(oid, sumPrice, format, "未付款", name, phone, addr, userId);
		 //再存入數據庫中
		 orderRoService.insertOrderInfo(order);
		 //之前用戶選擇提交的的商品信息是存入session中現在取出
		 List<CookieVo> strToList = (List<CookieVo>) ses.getAttribute("strToList");
		 ArrayList<OrderProducRo> orderProducRoList = new ArrayList<OrderProducRo>();
		 for (CookieVo cookieVo : strToList) {
			 //得到當前商品的id
			 Integer pid = cookieVo.getPid();
			 //得到當前商品的數量
			 Integer pcount = cookieVo.getPcount();
			//得到當前商品的單價
			 Integer pprice = cookieVo.getPprice();
			 OrderProducRo orderProducRo = new OrderProducRo(null, oid, pid, pcount, pprice);
			 orderProducRoList.add(orderProducRo);
		}
		 //吧訂單具體信息存入數據庫
		 orderProducService.OrderProducDao(orderProducRoList);
		 //通過用戶id查詢他的訂單昊
	
			Jedis jd=new Jedis("localhost", 6379);
			//可选：jd.auth("1111");
			jd.auth("1111");
			//b）通过连接jedis进行crud的操作
			String hget = jd.hget("cart",userId+"");
			//字符串转list這個是数据库里面的当前用户在购物车里面的所有商品
			List<CookieVo> redisList = JsonUtil.jsonStrToList(hget, CookieVo.class);
			//把数据库中的商品和提交的商品拿出来循环，把提交的商品清楚
			for (int i = 0; i < redisList.size(); i++) {
				Integer redisPid = redisList.get(i).getPid();
				for (int j = 0; j < strToList.size(); j++) {
					Integer orderPid = strToList.get(j).getPid();
					if(redisPid.intValue()==orderPid.intValue()){
						redisList.remove(i);
					}
				}
				
			}
			//再把对象转为字符串
			String objToJsonStr = JsonUtil.objToJsonStr(redisList);
			//存人redis数据库
			 jd.hset("cart",userId+"", objToJsonStr);
	
		
		 String result = result(oid, sumPrice);
		 return result;
	}

}
