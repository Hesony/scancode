package com.xiaonan.scancode.model.models;

/**
 * 买家信息
 */
public class BuyerInfo {
	private String buyer_phone;
	private String fans_type;
	private String buyer_id;
	private String fans_id;
	private String fans_nickname;

	public String getBuyer_phone() {
		return buyer_phone;
	}

	public void setBuyer_phone(String buyer_phone) {
		this.buyer_phone = buyer_phone;
	}

	public String getFans_type() {
		return fans_type;
	}

	public void setFans_type(String fans_type) {
		this.fans_type = fans_type;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getFans_id() {
		return fans_id;
	}

	public void setFans_id(String fans_id) {
		this.fans_id = fans_id;
	}

	public String getFans_nickname() {
		return fans_nickname;
	}

	public void setFans_nickname(String fans_nickname) {
		this.fans_nickname = fans_nickname;
	}
}
