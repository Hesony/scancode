package com.xiaonan.scancode.model.models;

public class ShopCommodityModel {
	/** 店铺ID 同样也是店铺核销注册的邀请码*/
	private String shopId;
	/** 店铺名称*/
	private String shopName;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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
