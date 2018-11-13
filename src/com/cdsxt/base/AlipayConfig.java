package com.cdsxt.base;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091800537805";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgUz+NpMfgwTt+sEprInGsY2IIa0WbTDck7wPeo+UUKyGi3rFD/JZ1g+jnBxweGaI85k1EONHfxsAhQCJSY5lBsr280Nr1XiNauk8GqD7Iso7VPe4CoHJxQ1zhzlAw/fOjTx8Mo1+zw1MuAY2rDf+2fC8VL5IqdK1n7ZWS3rJ33tTHxuHb26rg36wldkq83rRJuhNl6knLmInOibJxUTUQkk0PEtVZab6I7bODuJ1gQ+TW7YvTPqYFZlQ1UuS2Y8SHDDhNV/M8QT+i1GUjRmjScu5Jy8JWL704RBIfzQT4ZuV5vAVQYbsmEOe6upSylovRADNhKMv6SkdMvLWa75BPAgMBAAECggEAGJzPG+KZIMLpbEiKFCpkgw96xEoblHy91nivAmXszAzXDBbd5c8IFiBbB+SKh4Bt7KV6ZSfH6G+tnS0oV7ecln5nLG5vvs1l5g7GBQKdKNhonwnz2QliqEqsHqo6m1rRJVgHLzyBe6pXwa9RXVo30H7+B2WXLdddq5/In5R6l3YqGL4WZcoP1+5mg4ANohYRqjT8LO/8TpuOdHa7GkN5R8Vhot74pTr2YNVHsngrPkqnOd9zT8BrMkLApuCSE2QDP9M76eDqkODNHcqpxbzQnz4+tSE1Jbv1ubGjraqG7CyKMm8bVmOs6ANoZrp5gQDHEijKWfDibRVrCiziamwECQKBgQDqyhRIfbsZHnRtQJHP13nq+7WeVSz1MYKrRYUF/wZ3ri2JnxcANusS++FSlJBxqhx20yy7hlpvNn55QbqMooK/AMDcomXaidz/xftpGm82xfLZfpvwq5tQY0abZcsTG5ZrOB6ZxtToO+x+KXy3p1DiFg2ZehaDrJLoYktEjKhxcwKBgQCuzw17+2pK0c6LnNgIv0j0webhdk+hvELhJ9B/VT6qROLiBAGLY//qBet3DVZ80Vts+8WRMTBfJXhbwzGF2pM4eBv8jWIX1kJodR1kJPe0bSsfUXyNrekK9Ge2NBylljF9NWTJKVfQm2h3dOy9U+JmqM8eP29mqPcbWEPHVMy+tQKBgQDEraEOFJzNbvCSsHs0w0jy6gX661js0JuoQ2UqX7aYPMUSurz2xgpnba4TkjXpsVmExGN9dw98iAasJr5RnrStscDdUgDGb6Q8cimnoqg1Ft7XCLMyiV5imbcE5+GUURDRIkKoCKJDJCd4i+JYqgUcTuL3hQklJkQt/GEWvElCNwKBgC3VLcTnC1xonA3w5peMh7VcrYtJuOE/+g0MolbwY8jC3PXDdSA17OBQAweo4JdDUQRHEurZicQ4j9EHYZGl2FnC7BuQejqju6+lnTonkyakRN0mQVDoWyS7JgIYsbYcpgcdG7q+cz7HsGE5r+SH/OFLu1pD6ZJyFK//uW2m5zPNAoGAaGufYQKgIGpDIZkvRg/wgSL+bvR5Za8EZmo4UGxJShVIQ4DWgkP+xATbO4//HtXUlffAmU2XRFxCIFYMqJrTjURxjKLN2SF+6cS4NtbMJWRjDBzQxktjMdoaqLqRwp581BkqQ9BTertBkm3QC9wuYeU9K7+FF0mFzT+D544DsTQ=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8bfUjoVFXw6BTyOQpmBD5PLfbCTxzrkDAja8wvfnwIzdxT0AiaY9dLxKaC/2fqVLAiq+oL/j1dVv9UvleQz+QQVp/AAKH90P5mD95Y0WqdjLT3Kej3ntpWdnxfvgG+xnIOOdtp+BAzQzGPjojnXcDN+S0OsqnbjdQy8hfiL8RI8DF14rTgv6a3FnM28NYMxEOX06mjJPS0qFoxitDMph2ehaCr8+cDG0yI9s8Y5zqU/PB6s9tI91v1mLxPiDh29AXB6B9zIVGfzL/4qzKaPAraeYIj3ouh2tKILgw3Vk/l1EbIrr2KxXgN/lGbnSi2gD6umY/55ZPjwFxlBMCPPr3QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://53ea651c.ngrok.io/notify_url.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "https://53ea651c.ngrok.io/return_url.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

