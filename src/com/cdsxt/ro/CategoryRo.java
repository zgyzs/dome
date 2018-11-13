package com.cdsxt.ro;

import java.util.List;

/**
 * 值对象：封装数据的
 * 
 */
public class CategoryRo {
	
	private Integer cid;
	private String cname;
	private List<CategorySecondRo> listCs;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<CategorySecondRo> getListCs() {
		return listCs;
	}
	public void setListCs(List<CategorySecondRo> listCs) {
		this.listCs = listCs;
	}
}
