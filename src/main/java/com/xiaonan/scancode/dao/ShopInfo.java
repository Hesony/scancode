package com.xiaonan.scancode.dao;

public class ShopInfo {

	/** 店铺ID 同样也是店铺核销注册的邀请码*/
	private String shopId;
	/** 店铺名称 */
	private String shopName;


	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
