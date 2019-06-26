package com.xiaonan.scancode.service.Impl;

import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.dao.mapper.StaffInfoMapper;
import com.xiaonan.scancode.model.models.StaffModel;
import com.xiaonan.scancode.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffInfoMapper mapper;

	@Override
	public List<StaffModel> selectAllStaff() {
		List<StaffModel> staffModels = null;
		staffModels = mapper.selectAllStaff();
		return staffModels;
	}

	@Override
	public StaffInfo selectByOpenid(String openid) {
		return mapper.selectByOpenid(openid);
	}

	@Override
	public void updateVerifyMessage(String openid, String staff) {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo.setStaff(staff);
		staffInfo.setOpenid(openid);
		mapper.updateByObject(staffInfo);
	}

	@Override
	public int deleteVerifyMessage(String openid) {
		return mapper.deleteByOpenid(openid);
	}
}
