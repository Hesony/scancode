package com.xiaonan.scancode.service;

import com.xiaonan.scancode.dao.ShopCommodity;
import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.model.models.ShopCommodityModel;

import java.util.List;

public interface ShopCommodityService {

	/**
	 * 新增商品编码
	 * @param shopCommodity
	 * @return
	 */
	 void addShopCommodity(ShopCommodity shopCommodity);

	/**
	 * 查看所有商品编码
	 * @return
	 */
	List<ShopCommodity> selectAllShopCommodity();
	List<ShopCommodityModel> selectAllShopCommodityModel();

	/**
	 * 查看店铺下的商品编码
	 * @param outerItemId
	 * @return
	 */
	ShopCommodity selectShopCommodityByItemId(String outerItemId);
	ShopCommodityModel selectShopCommodityModelByItemId(String outerItemId);

	/**
	 * 新增商品编码逻辑
	 */

	ResultVO addShopCommodity(String shopname, String outerItemId, String goodsTitle);

	/**
	 * 根据商品编码删除逻辑
	 */
	void deleteShopCommodity(String outerItemId);
}
