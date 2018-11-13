package com.cdsxt.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	
	/**
	 * 初始化map数据并返回map的过程
	 * --》模拟bean对象的构造器
	 * keyVals:装键值对的数据
	 * 格式；
	 * key,val,key,val ....
	 */
	public static Map<Object, Object> initMap(
			Object ...keyVals){
		Map<Object, Object> map=new HashMap<Object, Object>();
		
		for (int i = 0; i < keyVals.length; i+=2) {
			//取出key
			Object key=keyVals[i];
			Object val=keyVals[i+1];
			//放入map
			map.put(key, val);
		}
		//
		return map;
	}
	/**
	 * 初始化map数据并返回map的过程
	 * --》模拟bean对象的构造器
	 * keyVals:装键值对的数据
	 * 格式；
	 * key,val,key,val ....
	 */
	public static Map<String, Object> initMap2(
			Object ...keyVals){
		Map<String, Object> map=new HashMap<String, Object>();
		
		for (int i = 0; i < keyVals.length; i+=2) {
			//取出key
			String key=(String) keyVals[i];
			Object val=keyVals[i+1];
			//放入map
			map.put(key, val);
		}
		//
		return map;
	}
}
