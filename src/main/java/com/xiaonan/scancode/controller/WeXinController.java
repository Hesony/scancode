package com.xiaonan.scancode.controller;

import com.xiaonan.scancode.constants.WeiXinConstants;
import com.xiaonan.scancode.model.result.OAuth2AccessTokenResult;
import com.xiaonan.scancode.service.Impl.WeiXinServiceImpl;
import com.xiaonan.scancode.utils.JsSignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "/wechat")
public class WeXinController {

	@Autowired
	private WeiXinServiceImpl weiXinService;

	@RequestMapping(value = "/scan")
	public String scan(HttpServletRequest request, Model model, Map<String, String> map) {
		String openid = request.getParameter("openid");
		String oAuth2AccessToken = request.getParameter("oAuth2AccessToken");
		//判断是否为核销员（包括BOSS）
		String verify = weiXinService.judgeOpenid(openid);
		if (!"成功".equals(verify)) {
			map.put("msg",verify);
			model.addAllAttributes(map);
			return "youzan/error";
		}
		String url = request.getRequestURL().toString() + "?openid=" + openid + "&oAuth2AccessToken=" + oAuth2AccessToken;
		Map<String, String> resultMap = new HashMap<>(16);
		log.info("url={}", url);
		resultMap = JsSignUtil.sign(url);
		map.put("appId", resultMap.get("appId"));
		map.put("nonceStr", resultMap.get("nonceStr"));
		map.put("timestamp", resultMap.get("timestamp"));
		map.put("signature", resultMap.get("signature"));
		map.put("openid", openid);//新增返回openid
		model.addAllAttributes(map);
		return "wechat/scan";
	}

	/**
	 * 获取code
	 *
	 * @param returnUrl
	 * @return
	 */
	@GetMapping(value = "/authorize")
	public String authorize(@RequestParam("returnUrl") String returnUrl) {
		log.info("认证请求开始,重定向地址为：{}", returnUrl);
		String url = WeiXinConstants.DEMO_URL + "/wechat/userInfo";
		String redirectUrl = weiXinService.oauth2buildAuthorizationUrl(url, "snsapi_userinfo", returnUrl);
		return "redirect:" + redirectUrl;//重定向到下面controller
	}

	/**
	 * 获取OAuth2AccessToken和openid
	 *
	 * @param code
	 * @param returnUrl
	 * @return
	 */
	@GetMapping(value = "/userInfo")
	public String userInfo(@RequestParam("code") String code,
						   @RequestParam("state") String returnUrl) {
		log.info(code);
		OAuth2AccessTokenResult oAuth2AccessTokenResult = new OAuth2AccessTokenResult();
		oAuth2AccessTokenResult = weiXinService.oauth2getAccessToken(code);
		//获取openid
		String openid = oAuth2AccessTokenResult.getOpenId();
		String oAuth2AccessToken = oAuth2AccessTokenResult.getAccessToken();
		String param = "?openid=" + openid + "&oAuth2AccessToken=" + oAuth2AccessToken;
		log.info("openid为：{}", openid);
		log.info("获取用户信息后重定向地址为：{}{}", returnUrl, param);
		return "redirect:" + returnUrl + param ;
		//returnUrl是请求 /authorize 的时候带的参数
	}

}
