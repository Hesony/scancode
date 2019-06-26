package com.xiaonan.scancode.model.models;

public class VerifyLogModel {
	private String shopName;
	private String openid;
	private String nickname;
	private String createTime;
	//核销的电子券码
	private String ticketCode;
	//订单号
	private String tid;
	//二维码code
	private String scanCode;
	//商品编码
	private String outerItemId;
	//商品名称
	private String goodsTitle;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getScanCode() {
		return scanCode;
	}

	public void setScanCode(String scanCode) {
		this.scanCode = scanCode;
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
