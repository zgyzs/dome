package com.cdsxt.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 获取cookie的值
	 * @param req 请求对象
	 * @param cookieName cookie的名字
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest req,String cookieName){
		
		Cookie[] cookieArr=req.getCookies();
		//cookie的值
		String cookieVal=null;
		for (Cookie cookie : cookieArr) {
			if (cookieName.equals(cookie.getName())) {
				cookieVal=cookie.getValue();
				return cookieVal;
			}
		}
		//找不到对应值返回null
		return null;
	}
	
	public static void deleteCookie(HttpServletRequest req,HttpServletResponse resp,String cookieName){
		Cookie[] cookieArr=req.getCookies();
		
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
				resp.addCookie(ck);
				return;
			}
		}
	}
}
