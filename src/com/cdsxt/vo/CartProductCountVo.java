package com.cdsxt.vo;

/**
 * 
 * 购物车商品的统计信息
 * 
 * @author 成都尚学堂 & mr zeng
 * 客服热线：028-65176856
 * 网址： www.cd-sxt.com
 */
public class CartProductCountVo {
	//总价
	private int countPrice;
	//总分类数量
	private int countCate;
	//总商品数量
	private int countPcount;

	public CartProductCountVo() {
		
	}
	public CartProductCountVo(int countPrice, int countCate, int countPcount) {
		super();
		this.countPrice = countPrice;
		this.countCate = countCate;
		this.countPcount = countPcount;
	}


	public int getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(int countPrice) {
		this.countPrice = countPrice;
	}

	public int getCountCate() {
		return countCate;
	}

	public void setCountCate(int countCate) {
		this.countCate = countCate;
	}


	public int getCountPcount() {
		return countPcount;
	}


	public void setCountPcount(int countPcount) {
		this.countPcount = countPcount;
	}

	
	
}
