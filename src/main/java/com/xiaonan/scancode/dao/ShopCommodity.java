package com.xiaonan.scancode.dao;

public class ShopCommodity {
	/** 店铺ID 同样也是店铺核销注册的邀请码*/
	private String shopId;
	/** 电子券商品编码 */
	private String outerItemId;
	/** 电子券商品名称 */
	private String goodsTitle;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getOuterItemId() {
		return outerItemId;
	}

	public void setOuterItemId(String outerItemId) {
		this.outerItemId = outerItemId;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
}
