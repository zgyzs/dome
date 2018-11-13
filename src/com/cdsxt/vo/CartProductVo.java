package com.cdsxt.vo;

public class CartProductVo {
	private Integer pid;
	private String pname;
	private Integer pcount;
	private Integer pprice;
	private String pimg;
	
	public CartProductVo() {
		
	}
	
	public CartProductVo(Integer pid, String pname, Integer pcount,
			Integer pprice, String pimg) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcount = pcount;
		this.pprice = pprice;
		this.pimg = pimg;
	}



	public CartProductVo(Integer pid, Integer pcount, Integer pprice) {
		super();
		this.pid = pid;
		this.pcount = pcount;
		this.pprice = pprice;
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPcount() {
		return pcount;
	}
	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}
	public Integer getPprice() {
		return pprice;
	}
	public void setPprice(Integer pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
}
