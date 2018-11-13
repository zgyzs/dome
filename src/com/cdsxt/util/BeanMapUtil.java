package com.cdsxt.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanMapUtil {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 
	 * @Title: convertMap
	 * @Description: 使用泛型Map转bean 首先先把传入的实体bean的类型通过反射实例化
	 * 
	 * Map的key和val对应bean的成员变量和值
	 * map的val的类型和成员变量值的类型【必须一致-才会进行设置值】
	 *  
	 * @return T 返回类型
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T mapToBean(Map map, Class<T> tc)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException,
			NoSuchMethodException, InstantiationException {
		T t = tc.newInstance();
		Iterator it = map.entrySet().iterator();
		Method[] methods = tc.getDeclaredMethods();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key=entry.getKey();
			Object val=entry.getValue();
			
			String methodName = "set"+ fristToUpperCase(key.toString());
			//根据【方法名和类型找方法】
			try {
				Method method =  tc.getDeclaredMethod(methodName, val.getClass());
				//执行方法
				method.invoke(t, val);
			} catch (Exception e) {
				System.err.println("BeanMapUtil-mapToBean没有找到找到方法："+methodName+"-"+val.getClass());
			}
		}
		return t;
	}

	/**
	 * 
	 * @Title: convertBean
	 * @Description: 实体bean转成Map 遍历对象所有方法
	 *               获取实体bean中get的方法，使用反射的获取方法返回值，如果值不为空，就为map的value，
	 *               然后把get方法去除get的部分，首字母变小写，为map的key
	 */
	public static Map beanToMap(Object obj) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Class cla = obj.getClass();
		Method[] methods = cla.getDeclaredMethods();
		Map map = new HashMap();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {
				String name = method.getName().substring(3,
						method.getName().length());
				String key = fristToLowerCase(name);
				Object value = method.invoke(obj);
				if (null != value)
					map.put(key, value);
			}
		}
		return map;
	}

	/**
	 * 
	 * @Title: fristToUpperCase
	 * @Description: 首字母变大写
	 * @param @param str
	 * @param @return 设定参数
	 * @return String 返回类型
	 * @throws
	 */
	public static String fristToUpperCase(String str) {
		str = str.substring(0, 1).toUpperCase()
				+ str.substring(1, str.length());
		return str;
	}
	/**
	 * 
	 * @Title: fristToUpperCase
	 * @Description: 首字母变小写
	 * @param @param str
	 * @param @return 设定参数
	 * @return String 返回类型
	 * @throws
	 */
	public static String fristToLowerCase(String str) {
		str = str.substring(0, 1).toLowerCase()
				+ str.substring(1, str.length());
		return str;
	}

}
