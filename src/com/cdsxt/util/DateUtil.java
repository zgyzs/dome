package com.cdsxt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//2017-11-1 10:56:55
	private static DateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 2017-11-1 10:56:55
	 */
	public static String dateToStr(Date date){
		String dateStr= df1.format(date);
		return dateStr;
	}
	public static Date strToDate(String dateStr){
		Date date;
		try {
			date = df1.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println("解析时间错误："+e.toString());
			return null;
		}
	}
	
}
