package com.cdsxt.vo;

import java.io.UnsupportedEncodingException;

public class AlipayOrderPayVo {

	// 商户订单号，商户网站订单系统中唯一订单号，必填
	private String outTradeNo;
	// = new
	// String(super.req.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	// 付款金额，必填
	private String totalAmount;
	// 订单名称，必填
	private	 String subject;
	// 商品描述，可空
	private String body;
	
	
	public AlipayOrderPayVo() {
		// TODO Auto-generated constructor stub
	}


	public AlipayOrderPayVo(String outTradeNo, String totalAmount,
			String subject, String body) {
		this.setOutTradeNo(outTradeNo);
		this.setTotalAmount(totalAmount);
		this.setBody(body);
		this.setSubject(subject);
	}

	/**
	 * 编码功能
	 * @param outTradeNo
	 */

	private String encoding(String data){
		try {
			String enStr=new String( data.getBytes("ISO-8859-1"),"UTF-8");
			return enStr;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = encoding(outTradeNo);
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount =  encoding(totalAmount);
	}

	public void setSubject(String subject) {
		this.subject = encoding(subject);
	}

	public void setBody(String body) {
		this.body = encoding(body);
	}
	
	
	public String getOutTradeNo() {
		return outTradeNo;
	}


	public String getTotalAmount() {
		return totalAmount;
	}


	public String getSubject() {
		return subject;
	}


	public String getBody() {
		return body;
	}


	
	
	
	

}
