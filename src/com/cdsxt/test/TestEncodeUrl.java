package com.cdsxt.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class TestEncodeUrl {
	
	/**
	 * =================url编码解码能演示=====================================
	 */
	
	@Test
	public void encodeUrl()throws Exception{
		String data="hello美女";
		String data2= URLEncoder.encode(data, "utf-8");
		System.out.println("url编码的数据："+data2);
	}
	
	@Test
	public void decodeUrl()throws Exception{
		String data="hello%E7%BE%8E%E5%A5%B3";
		String data2= URLDecoder.decode(data, "utf-8");
		System.out.println("url解码的数据："+data2);
		
//		String data3=new String(data.getBytes("iso8859-1"),"utf-8");
//		System.out.println("url解码的数据："+data3);
	}
	
	
	/**
	 * =================junit 功能演示=====================================
	 */
	@Test
	public void test1(){
		System.out.println("TestEncodeUrl.test1()");
	}
	
	@Test
	public void test2(){
		System.out.println("TestEncodeUrl.test2()");
		int a=1/0;
	}
	
	
	public void test3(){
		System.out.println("TestEncodeUrl.test3()");
	}
	
	@Test
	public void test4(){
		System.out.println("TestEncodeUrl.test4()");
	}
}
