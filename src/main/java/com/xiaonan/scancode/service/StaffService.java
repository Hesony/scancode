package com.xiaonan.scancode.service;

import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.model.models.StaffModel;

import java.util.List;

public interface StaffService {

	/**
	 * 查看核销员信息列表
	 * @return
	 */
	List<StaffModel> selectAllStaff();

	StaffInfo selectByOpenid(String openid);

	/**
	 * 审核核销员
	 */
	void updateVerifyMessage(String openid, String staff);

	/**
	 * 删除核销员
	 */
	int deleteVerifyMessage(String openid);
}
