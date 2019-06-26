package com.xiaonan.scancode.utils;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.WeiXinConstants;
import com.xiaonan.scancode.model.result.WeiXinAccessTokenResult;
import com.xiaonan.scancode.model.result.WeiXinTicketResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeiXinUtil {

	/**
	 * 获取access_token
	 * @return
	 */
	public static String getAccessToken() {
		WeiXinAccessTokenResult result = new WeiXinAccessTokenResult();
		String url = String.format(WeiXinConstants.ACCESS_TOKEN_URL, WeiXinConstants.APP_ID,WeiXinConstants.APP_SECERT);
		log.info("获取微信accessToken的url：{}", url);
		String getResult = HttpRequestUtils.httpGet(url);
		log.info("获取微信accessToken结果：{}", getResult);
		result = JSONObject.parseObject(getResult, WeiXinAccessTokenResult.class);
		String accessToken = result.getAccess_token();
		return accessToken;
	}

	/**
	 * 获取ticket
	 * @param accessToken
	 * @return
	 */
	public static String getJsApiTicket(String accessToken) {
		WeiXinTicketResult result = new WeiXinTicketResult();
		String url = String.format(WeiXinConstants.TICKET_URL,accessToken);
		result = JSONObject.parseObject(HttpRequestUtils.httpGet(url), WeiXinTicketResult.class);
		String ticket = result.getTicket();
		return ticket;
	}



}
