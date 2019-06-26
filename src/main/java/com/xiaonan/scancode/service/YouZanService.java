package com.xiaonan.scancode.service;

import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.model.result.YouZanResult;

public interface YouZanService {

	/**
	 * 通过电子卡券二维码的码号(扫用户核销的二维码) 获取电子卡券信息
	 * @param scancode
	 * @return
	 */
	YouZanResult getVerifyTicket(String scancode);


	/**
	 *电子卡券单个码券核销
	 * @param youZanResult  获取电子卡券信息结果 ↑
	 * @param openid
	 * @return 核销成功返回true，核销失败返回false
	 */
	ResultVO verifyTicket(YouZanResult youZanResult, String openid);
}
