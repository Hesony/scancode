package com.xiaonan.scancode.service;

import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.model.models.VerifyLogModel;

import java.util.List;
import java.util.Map;

public interface RegisterService {

	/**
	 * 核销员注册逻辑
	 * @param openid
	 * @param shopId
	 * @param oAuth2AccessToken
	 * @return
	 */
	Boolean register(String openid, String oAuth2AccessToken,String shopId);

	/**
	 * BOSS查看所属店铺下已核销电子券码列表
	 * @param openid
	 * @return
	 */
	List<VerifyLogModel> findVerifyLog(String openid);
}
