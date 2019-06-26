package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.dao.mapper.ShopInfoMapper;
import com.xiaonan.scancode.dao.mapper.StaffInfoMapper;
import com.xiaonan.scancode.dao.mapper.VerifyLogMapper;
import com.xiaonan.scancode.model.models.VerifyLogModel;
import com.xiaonan.scancode.model.result.SnsapiUserinfo;
import com.xiaonan.scancode.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 注册实现类
 */
@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private ShopInfoMapper shopInfoMapper;

	@Autowired
	private StaffInfoMapper staffInfoMapper;

	@Autowired
	private VerifyLogMapper verifyLogMapper;

	@Autowired WeiXinServiceImpl weiXinService;

	@Override
	public Boolean register(String openid, String oAuth2AccessToken,String shopId) {
		SnsapiUserinfo snsapiUserinfo = weiXinService.getSnsapiUserinfo(oAuth2AccessToken, openid);

		ShopInfo  shopInfo= new ShopInfo();
		StaffInfo staffInfo = new StaffInfo();

		shopInfo = shopInfoMapper.selectByShopId(shopId);
		staffInfo = staffInfoMapper.selectByOpenid(openid);
		if (null == shopInfo || null != staffInfo) {
			log.info("该openid:{}邀请码{}错误,或者openid已存在", openid, shopId);
			return false;
		}
		StaffInfo staffInfoNew = new StaffInfo();
		BeanUtils.copyProperties(snsapiUserinfo, staffInfoNew);
		staffInfoNew.setShopId(shopId);
		staffInfoNew.setStaff("NOTYET");
		staffInfoMapper.insertByObject(staffInfoNew);
		return true;
	}

	@Override
	public List<VerifyLogModel> findVerifyLog(String openid) {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = staffInfoMapper.selectByOpenid(openid);
		String shopId = staffInfo.getShopId();
		List<VerifyLogModel> list = verifyLogMapper.selectAllVerifyMessageByShopId(shopId);
		return list;
	}
}
