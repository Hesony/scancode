package com.xiaonan.scancode.controller;

import com.xiaonan.scancode.service.Impl.RegisterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private RegisterServiceImpl registerService;

	@RequestMapping(value = "/index")
	public String index(@RequestParam("openid") String openid,
						@RequestParam("oAuth2AccessToken") String oAuth2AccessToken,
						Model model, Map<String, String> map) {
		map.put("openid",openid);
		map.put("oAuth2AccessToken", oAuth2AccessToken);
		model.addAllAttributes(map);
		return "register/index";//跳转到注册页面
	}

	@RequestMapping(value = "registerform")
	public String register(HttpServletRequest request, Model model, Map<String, String> map) {
		String openid = request.getParameter("openid");
		String shopId = request.getParameter("shop_id");
		String oAuth2AccessToken = request.getParameter("oAuth2AccessToken");
		log.info("请求参数为openid:{}|shop_id:{}|oAuth2AccessToken:{}",openid,shopId,oAuth2AccessToken);
		Boolean result = registerService.register(openid,oAuth2AccessToken,shopId);
		if (result == true) {
			map.put("msg","恭喜注册成功");
			model.addAllAttributes(map);
			return "youzan/success";
		}
		map.put("msg","注册失败,请联系管理员");
		model.addAllAttributes(map);
		return "youzan/error";
	}

}
