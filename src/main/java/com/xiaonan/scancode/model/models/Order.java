package com.xiaonan.scancode.model.models;

public class Order {
	private String outerItemId; //商品编码

	private String price; //单价

	private String title; //商品名称

	public String getOuterItemId() {
		return outerItemId;
	}

	public void setOuterItemId(String outerItemId) {
		this.outerItemId = outerItemId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
