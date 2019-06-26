package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.ShopCommodity;
import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.dao.mapper.ShopCommodityMapper;
import com.xiaonan.scancode.dao.mapper.ShopInfoMapper;
import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.model.models.ShopCommodityModel;
import com.xiaonan.scancode.service.ShopCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCommodityServiceImpl implements ShopCommodityService {
	@Autowired
	private ShopCommodityMapper shopCommodityMapper;
	@Autowired
	private ShopInfoMapper shopInfoMapper;

	@Override
	public void addShopCommodity(ShopCommodity shopCommodity) {
		shopCommodityMapper.insertByObject(shopCommodity);
	}

	@Override
	public List<ShopCommodity> selectAllShopCommodity() {
		return shopCommodityMapper.selectAllShopCommodity();
	}


	@Override
	public List<ShopCommodityModel> selectAllShopCommodityModel() {
		return shopCommodityMapper.selectAllShopCommodityModel();
	}

	@Override
	public ShopCommodity selectShopCommodityByItemId(String outerItemId) {
		return shopCommodityMapper.selectShopCommodityByItemId(outerItemId);
	}

	@Override
	public ShopCommodityModel selectShopCommodityModelByItemId(String outerItemId) {
		return shopCommodityMapper.selectShopCommodityModelByItemId(outerItemId);
	}

	@Override
	public ResultVO addShopCommodity(String shopname, String outerItemId, String goodsTitle) {
		ResultVO resultVO = new ResultVO();
		ShopInfo shopInfo = new ShopInfo();
		ShopCommodity shopCommodity = new ShopCommodity();
		shopInfo = shopInfoMapper.selectByShopName(shopname);
		if (null == shopInfo) {
			resultVO.setCode("001");
			resultVO.setMsg("未查询到该店铺，请确认店铺名称! ");
			return resultVO;
		}
		String shopId = shopInfo.getShopId();
		shopCommodity.setShopId(shopId);
		shopCommodity.setOuterItemId(outerItemId);
		shopCommodity.setGoodsTitle(goodsTitle);
		shopCommodityMapper.insertByObject(shopCommodity);

		resultVO.setCode("000");
		resultVO.setMsg("新增电子券商品编码成功！");
		return resultVO;
	}

	@Override
	public void deleteShopCommodity(String outerItemId) {
		shopCommodityMapper.deleteByItemId(outerItemId);

	}
}
