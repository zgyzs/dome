package com.cdsxt.ro;

import java.util.Date;

public class OrderRo {
	
	/**
	 * 表映射
	 */
	private String oid;
	private Integer sumPrice;
	private Date orderTime;
	private String state;
	private String name;
	private String phone;
	private String addr;
	private Integer uid;
	
	
	public OrderRo() {
		// TODO Auto-generated constructor stub
	}
	
	


	public OrderRo(String oid, Integer sumPrice, Date orderTime,
			String state, String name, String phone, String addr, Integer uid) {
		super();
		this.oid = oid;
		this.sumPrice = sumPrice;
		this.orderTime = orderTime;
		this.state = state;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.uid = uid;
	}




	public String getOid() {
		return oid;
	}




	public void setOid(String oid) {
		this.oid = oid;
	}




	public Integer getSumPrice() {
		return sumPrice;
	}




	public void setSumPrice(Integer sumPrice) {
		this.sumPrice = sumPrice;
	}




	public Date getOrderTime() {
		return orderTime;
	}




	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getAddr() {
		return addr;
	}




	public void setAddr(String addr) {
		this.addr = addr;
	}




	public Integer getUid() {
		return uid;
	}




	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	


	
}
