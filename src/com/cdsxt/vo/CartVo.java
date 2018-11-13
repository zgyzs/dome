package com.cdsxt.vo;

/**
 * @author 成都尚学堂 & mr zeng
 * 客服热线：028-65176856
 * 网址： www.cd-sxt.com
 * 
 * 购物车的信息
 * a）购物车商品的数组
 * b）购物车商品的统计信息
 */
public class CartVo {
	
	// a）购物车商品的数组
	private CartProductVo[] cartProArr;
	
	//b）购物车商品的统计信息
	private CartProductCountVo cartProCountInfo;
	
	
	
	
	public CartVo(CartProductVo[] cartProArr,
			CartProductCountVo cartProCountInfo) {
		super();
		this.cartProArr = cartProArr;
		this.cartProCountInfo = cartProCountInfo;
	}
	public CartProductVo[] getCartProArr() {
		return cartProArr;
	}
	public void setCartProArr(CartProductVo[] cartProArr) {
		this.cartProArr = cartProArr;
	}
	public CartProductCountVo getCartProCountInfo() {
		return cartProCountInfo;
	}
	public void setCartProCountInfo(CartProductCountVo cartProCountInfo) {
		this.cartProCountInfo = cartProCountInfo;
	}
}
