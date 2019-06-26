package com.xiaonan.scancode.model.models;

import java.util.List;

/**
 * 交易基础信息结构体
 */
public class FullOrderInfo {

	private List<Order> orders;//订单明细结构体

	private BuyerInfo buyerInfo;

	private OrderInfo orderInfo;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public BuyerInfo getBuyerInfo() {
		return buyerInfo;
	}

	public void setBuyerInfo(BuyerInfo buyerInfo) {
		this.buyerInfo = buyerInfo;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
}
