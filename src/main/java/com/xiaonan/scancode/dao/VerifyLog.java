package com.xiaonan.scancode.dao;


public class VerifyLog {
	private String openid;
	//核销的电子券码
	private String ticketCode;
	//订单号
	private String tid;
	//二维码code
	private String scanCode;
	private String createTime;

	private String outerItemId;
	private String goodsTitle;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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
