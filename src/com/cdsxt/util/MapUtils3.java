package com.cdsxt.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 组合map得到它的功能
 * 
 * @author 成都尚学堂 & mr zeng
 * 客服热线：028-65176856
 * 网址： www.cd-sxt.com
 * @param <KeyType>
 * @param <ValType>
 */
public class MapUtils3<KeyType, ValType>  {
	private HashMap<KeyType, ValType> hm;
	public MapUtils3() {
		this.hm=new HashMap<KeyType, ValType>();
	}
	
	
	public static void main(String[] args) {
		MapUtils3<String, Object> map=new MapUtils3<String, Object>();
		map.putSelf("name", "刘德华").putSelf("age", 18).putSelf("sex", "男");
		System.out.println(map);
	}
	
	/**
	 * 转为map
	 */
	public Map<KeyType, ValType> toMap(){
		return this.hm;
	}
	
	//添加键值对-并返回自己
	public MapUtils3<KeyType, ValType> putSelf(KeyType key, ValType val){
		/**
		 * 利用组合的map功能
		 */
		this.hm.put(key, val);
		/**
		 * 返回自己实现链式编程
		 */
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (Map.Entry<KeyType,ValType> entry : this.hm.entrySet()) {
			sb.append("key:"+entry.getKey());
			sb.append("val:"+entry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
}
