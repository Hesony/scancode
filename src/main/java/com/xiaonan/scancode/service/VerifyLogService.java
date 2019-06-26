package com.xiaonan.scancode.service;

import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.model.models.VerifyLogModel;

import java.util.List;

public interface VerifyLogService {

	/**
	 * 已核销电子券列表
	 * @return
	 */
	List<VerifyLogModel> selectAllVerifyLog();

	/**
	 * 插入电子券列表
	 */
	int insertVerifyLog(VerifyLog verifyLog);
}
