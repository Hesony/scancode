package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.dao.mapper.ShopInfoMapper;
import com.xiaonan.scancode.service.ShopService;
import com.xiaonan.scancode.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopInfoMapper shopInfoMapper;

	@Override
	public List<ShopInfo> shoplist() {
		List<ShopInfo> shopInfoList = shopInfoMapper.selectAllShop();
		return shopInfoList;
	}

	@Override
	public void addshop(String shopName) {
		ShopInfo shopInfo = new ShopInfo();
		String shopId = KeyUtil.genUniqueKey();
		shopInfo.setShopId(shopId);
		shopInfo.setShopName(shopName);
		try {
			shopInfoMapper.insertByObject(shopInfo);
		} catch (Exception e) {
			log.error("新插入店铺失败，店铺名:{}", shopName);
		}
	}

	@Override
	public void deleteshop(String shopId) {
		shopInfoMapper.deleteShop(shopId);
	}
}
