package com.cdsxt.test;

import java.util.HashMap;
import java.util.Map;




import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.cdsxt.util.HttpUtils;

public class Test2 {
	public static void main(String[] args) {
	    String host = "https://cexpress.market.alicloudapi.com";
	    String path = "/cexpress";
	    String method = "GET";
	    String appcode = "dc5ccba979c44db58366ce6b16f825de";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("no", "780098068058");
	    querys.put("type", "zto");


	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
