package com.xiaonan.scancode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.dao.mapper.StaffInfoMapper;
import com.xiaonan.scancode.model.Response;
import com.xiaonan.scancode.model.models.FullOrderInfo;
import com.xiaonan.scancode.model.models.Order;
import com.xiaonan.scancode.model.result.YouZanResult;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import com.xiaonan.scancode.utils.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

public class TestJs {



	public static void main(String[] args) {
		String url = String.format("https://open.youzan.com/api/oauthentry/youzan.user.weixin.openid/3.0.0/get?access_token=%s&mobile=%s"
				, "3b3062acff99320a83b73b4934e1bed0", "13671871174");
		String a = HttpRequestUtils.httpGet(url);
		System.out.println(a);
	}

}
