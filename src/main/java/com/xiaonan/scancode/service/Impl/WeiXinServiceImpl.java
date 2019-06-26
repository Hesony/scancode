package com.xiaonan.scancode.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.WeiXinConstants;
import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.dao.mapper.StaffInfoMapper;
import com.xiaonan.scancode.model.result.OAuth2AccessTokenResult;
import com.xiaonan.scancode.model.result.SnsapiUserinfo;
import com.xiaonan.scancode.service.WeiXinService;
import com.xiaonan.scancode.utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeiXinServiceImpl implements WeiXinService {

	@Autowired
	private StaffInfoMapper staffInfoMapper;


	@Override
	public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state) {
		return String.format(WeiXinConstants.CONNECT_OAUTH2_AUTHORIZE_URL, WeiXinConstants.APP_ID,
				redirectURI, scope, state);
	}

	@Override
	public OAuth2AccessTokenResult oauth2getAccessToken(String code) {
		String url =  String.format(WeiXinConstants.OAUTH2_ACCESS_TOKEN_URL, WeiXinConstants.APP_ID,
				WeiXinConstants.APP_SECERT, code);
		OAuth2AccessTokenResult oAuth2AccessTokenResult = new OAuth2AccessTokenResult();
		String result = HttpRequestUtils.httpGet(url);
		oAuth2AccessTokenResult = JSONObject.parseObject(result, OAuth2AccessTokenResult.class);
		return oAuth2AccessTokenResult;
	}


	@Override
	public SnsapiUserinfo getSnsapiUserinfo(String oAuth2AccessToken ,String openid) {
		String url = String.format(WeiXinConstants.SNSAPI_USERINFO_URL, oAuth2AccessToken, openid);
		SnsapiUserinfo snsapiUserinfo = new SnsapiUserinfo();
		String result = HttpRequestUtils.httpGet(url);
		snsapiUserinfo = JSONObject.parseObject(result, SnsapiUserinfo.class);
		return snsapiUserinfo;
	}

	@Override
	public String judgeOpenid(String openid) {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = staffInfoMapper.selectByOpenid(openid);
		if (null == staffInfo || "".equals(staffInfo.getStaff())) {
			return "您无扫一扫权限，请联系管理员";
		}

		if ("NOTYET".equals(staffInfo.getStaff())) {
			return "您的核销权限正在审核，请联系管理员";
		}

		return "成功";


	}
}
