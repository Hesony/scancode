package com.xiaonan.scancode.service;

import com.xiaonan.scancode.dao.ShopInfo;

import java.util.List;

public interface ShopService {
	/**
	 * 店铺列表
	 * @return
	 */
	List<ShopInfo> shoplist();

	/**
	 * 新增店铺
	 */
	void addshop(String shopName);

	/**
	 * 删除店铺
	 */
	void deleteshop(String shopId);

}
