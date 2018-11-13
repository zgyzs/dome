package com.cdsxt.util;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.kerberos.KeyTab;

/**
 * 继承map得到它的功能
 * 
 * @author 成都尚学堂 & mr zeng
 * 客服热线：028-65176856
 * 网址： www.cd-sxt.com
 * @param <KeyType>
 * @param <ValType>
 */
public class MapUtils2<KeyType, ValType> extends HashMap<KeyType, ValType>{
	
	public static void main(String[] args) {
		MapUtils2<String, Object> map=new MapUtils2<String, Object>();
		map.putSelf("name", "刘德华").putSelf("age", 18).putSelf("sex", "男");
		System.out.println(map);
		//
		Object name1= map.get("name");
		String name2= (String) map.get("name");
		Integer age= (Integer) map.get("age");
		//
		String name3=map.getValue("name");
		Integer age2=map.getValue("age");
		
	}
	
	/**
	 * 封装get方法：带泛型处理，不用进行类型转换
	 */
	public  <VT> VT getValue(KeyType key){
		Object val= this.get(key);
		return (VT) val;
	}
	
	//添加键值对-并返回自己
	public MapUtils2<KeyType, ValType> putSelf(KeyType key, ValType val){
		/**
		 * 利用继承的map功能
		 */
		super.put(key, val);
		/**
		 * 返回自己实现链式编程
		 */
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (Map.Entry<KeyType,ValType> entry : this.entrySet()) {
			sb.append("key:"+entry.getKey());
			sb.append("val:"+entry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
