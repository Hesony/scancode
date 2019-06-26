package com.xiaonan.scancode.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.model.models.MsgPushEntity;
import com.xiaonan.scancode.service.Impl.NotifyHandleServiceImpl;
import com.xiaonan.scancode.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping(value = "/notify")
@Slf4j
public class NotifyController {

	@Autowired
	private NotifyHandleServiceImpl notifyHandleService;

	private static final int mode = 1 ; //服务商
	private static final String clientId = YouZanConstants.YOUZAN_CLIENT_ID; //服务商的秘钥证书
	private static final String clientSecret= YouZanConstants.YOUZAN_CLIENT_SECRET;//服务商的秘钥证书

	@RequestMapping(value = "/mainorder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object OrderNotify(@RequestBody MsgPushEntity entity) throws NoSuchAlgorithmException {
		log.info("进入接收方法--{}", entity.getType());
		JSONObject res = new JSONObject();
		res.put("code", 0);
		res.put("msg", "success");

		/**
		 *  判断是否为心跳检查消息
		 *  1.是则直接返回
		 */
		if (entity.isTest()) {
			return res;
		}

		/**
		 * 解析消息推送的模式  这步判断可以省略
		 * 0-商家自由消息推送 1-服务商消息推送
		 * 以服务商 举例
		 * 判断是否为服务商类型的消息
		 * 否则直接返回
		 */
		if (entity.getMode() != mode ){
			return res;
		}

		/**
		 * 判断消息是否合法
		 * 解析sign
		 * MD5 工具类开发者可以自行引入
		 */
		String sign= SecurityUtil.MD5(clientId+entity.getMsg()+clientSecret);
		if (!sign.equals(entity.getSign())){
			return res;
		}

		/**
		 * 对于msg 先进行URI解码
		 */
		String msg="";
		try {
			msg= URLDecoder.decode(entity.getMsg(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		//如果购买指定电子券卖家发货，则做业务处理
		if ("trade_TradePaid".equals(entity.getType())) {
			log.info(msg);
			// 参考文档对应的交易对象 进行JSON解码  业务处理等
			//todo:这里需要异步处理
			notifyHandleService.handleTradeMessage(msg);
		}


		/**
		 * 返回结果
		 */
		return res;
	}

}
