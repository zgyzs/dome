package com.cdsxt.test;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Test1 {

	@Test
	public void t1(){
		//a）获取redis的连接jedis
		Jedis jd=new Jedis("localhost", 6379);
		//可选：jd.auth("1111");
		jd.auth("1111");
		//b）通过连接jedis进行crud的操作
		Set<String> keys = jd.keys("*");
		System.out.println("所有的key："+keys);
		//c）关闭jedis连接
		jd.close();
	}
	@Test
	public  void t2(){
		//a）获取redis的连接jedis
		Jedis jd=new Jedis("localhost", 6379);
		//可选：jd.auth("1111");
		jd.auth("1111");
		//b）通过连接jedis进行crud的操作
		jd.hset("qwdsa","dsadsa","sasxas");
		System.out.println("11");
		//c）关闭jedis连接
		jd.close();
	}
	@Test
	public  void t3(){
		//a）获取redis的连接jedis
		Jedis jd=new Jedis("localhost", 6379);
		//可选：jd.auth("1111");
		jd.auth("1111");
		//b）通过连接jedis进行crud的操作
//		String hget = jd.hget("qwdsa","dsadsa");
		String hget = jd.hget("cart","1");
		System.out.println(hget);
		//c）关闭jedis连接
		jd.close();
	}
	

	
}
