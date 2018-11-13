package com.cdsxt.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.cdsxt.vo.CartProductVo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;

public class JsonUtil {
	
	/**
	 * 解析器：线程安全
	 */
	private static ObjectMapper jsonParse= new ObjectMapper();


	
	
	/**
	 * 字符串转数组
	 * 
	 * jsonStr 被转换的json字符串
	 * EleCls 数组的元素类型（javabean）
	 * 
	 * 【｛｝，｛｝，｛｝】
	 * 
	 */
	public static  <T> T[]  jsonStrToArr(String jsonStr,Class<T> EleCls){
		
		try {
			ArrayType arrType = ArrayType.construct(
					SimpleType.construct(EleCls), null, null);
			T[] arr;
			arr = jsonParse.readValue(jsonStr,
					arrType);
			return arr;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 字符串转list
	 * 
	 * jsonStr 被转换的json字符串
	 * EleCls 数组的元素类型（javabean）
	 * 
	 */
	public static  <T> List<T>  jsonStrToList(String jsonStr,Class<T> EleCls){
		T [] arr=jsonStrToArr(jsonStr, EleCls);
		//Arrays.asList==转的list是一个假list，像一个list，每一增删的功能==只能查询修改。。。
		List<T> list=new ArrayList<T>();
		Collections.addAll(list, arr);
		return list;
	}
	/**
	 * json字符串转map
	 */
	public static Map<String, String> jsonStrToMap(String jsonStr){
		try {
			Map map= jsonParse.readValue(jsonStr,Map.class);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Map<String, Object> jsonStrToMapObj(String jsonStr){
		try {
			Map map= jsonParse.readValue(jsonStr,Map.class);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * json字符串转bean
	 */
	public static <T> T jsonStrToBean(String jsonStr,Class<T> beanCls){
		try {
			T bean= jsonParse.readValue(jsonStr, beanCls);
			return bean;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 对象转json字符串
	 */
	public static String objToJsonStr(Object obj){
		try {
			String jsonStr= jsonParse.writeValueAsString(obj);
			return jsonStr;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
