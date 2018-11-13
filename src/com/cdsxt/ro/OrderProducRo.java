package com.cdsxt.ro;

public class OrderProducRo {
	private Integer id;
	private String oid;
	private Integer pid;
	private Integer count;
	private Integer buy_price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}
	public OrderProducRo(Integer id, String oid, Integer pid, Integer count,
			Integer buy_price) {
		super();
		this.id = id;
		this.oid = oid;
		this.pid = pid;
		this.count = count;
		this.buy_price = buy_price;
	}
	public OrderProducRo() {
		super();
	}
	
}
