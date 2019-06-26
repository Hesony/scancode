package com.xiaonan.scancode.controller;

import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.model.models.VerifyLogModel;
import com.xiaonan.scancode.service.Impl.RegisterServiceImpl;
import com.xiaonan.scancode.service.Impl.StaffServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "/boss")
public class BossController {

	@Autowired
	private RegisterServiceImpl registerService;
	@Autowired
	StaffServiceImpl staffService;

	@RequestMapping(value = "/verifylist")
	public String index(@RequestParam("openid") String openid,
						@RequestParam("oAuth2AccessToken") String oAuth2AccessToken,
						Model model, Map<String, Object> map) {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = staffService.selectByOpenid(openid);
		if (null == staffInfo) {
			map.put("msg", "您还未注册该功能,请联系管理员");
			model.addAllAttributes(map);
			return "youzan/error";
		}
		if (!"BOSS".equals(staffInfo.getStaff())) {
			map.put("msg", "您不是该店店长或者还未审核通过,请联系管理员");
			model.addAllAttributes(map);
			return "youzan/error";
		}
		List<VerifyLogModel> list = registerService.findVerifyLog(openid);
		map.put("list", list);
		model.addAllAttributes(map);
		return "register/verifylist";
	}
}
