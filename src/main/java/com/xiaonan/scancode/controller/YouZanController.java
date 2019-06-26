package com.xiaonan.scancode.controller;

import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.service.Impl.YouZanServiceImpl;
import com.xiaonan.scancode.utils.YouZanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "/youzan")
public class YouZanController {

	@Autowired
	private YouZanServiceImpl youZanService;

	@RequestMapping(value = "/verifyticket")
	public String doscan(@RequestParam("scancode") String scancode,
						 @RequestParam("openid") String openid,
						 Model model, Map<String, String> map) {
		log.info("核销的二维码为：{}", scancode);
		//判断核销二维码是否为这个openid所在店铺的二维码号，若不是该店铺的二维码号，返回错误
		ResultVO result = youZanService.verifyTicket(youZanService.getVerifyTicket(scancode), openid);
		if ("000".equals(result.getCode())) {
			map.put("msg", result.getMsg());
			model.addAllAttributes(map);
			return "youzan/success";
		} else {
			map.put("msg", result.getMsg());
			model.addAllAttributes(map);
			return "youzan/error";
		}
	}
}
