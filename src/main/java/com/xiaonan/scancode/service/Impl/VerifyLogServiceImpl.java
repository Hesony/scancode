package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.dao.mapper.VerifyLogMapper;
import com.xiaonan.scancode.model.models.VerifyLogModel;
import com.xiaonan.scancode.service.VerifyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyLogServiceImpl implements VerifyLogService {

	@Autowired
	private VerifyLogMapper mapper;

	@Override
	public List<VerifyLogModel> selectAllVerifyLog() {
		return  mapper.selectAllVerifyMessage();
	}

	@Override
	public int insertVerifyLog(VerifyLog verifyLog) {
		return mapper.insertByObject(verifyLog);
	}
}
