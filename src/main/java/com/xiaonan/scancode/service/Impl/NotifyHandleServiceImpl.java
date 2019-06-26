package com.xiaonan.scancode.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.CommonConstants;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.dao.CertCardInfo;
import com.xiaonan.scancode.dao.CertCardRecord;
import com.xiaonan.scancode.dao.CertValueInfo;
import com.xiaonan.scancode.dao.mapper.CertCardInfoMapper;
import com.xiaonan.scancode.dao.mapper.CertCardRecordMapper;
import com.xiaonan.scancode.model.Response;
import com.xiaonan.scancode.model.result.YouZanResult;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import com.xiaonan.scancode.utils.HttpRequestUtils;
import com.xiaonan.scancode.utils.TemplateMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.*;

@Service
@Slf4j
public class NotifyHandleServiceImpl {

	@Autowired
	private CertCardInfoMapper certCardInfoMapper;
	@Autowired
	private CertCardRecordMapper certCardRecordMapper;
	@Autowired
	private CertValueInfoServiceImpl certValueInfoService;

	//todo 新建线程池消费队列里数据
	private static ExecutorService executorService;

	static {
		log.info("应用启动时创建异步处理有赞回调的线程池开始");
		try {
			executorService = new ThreadPoolExecutor(3, 10, 60,
					TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		}catch (Exception e) {
			log.info("应用启动时创建异步处理有赞回调的线程池异常：{}", e.getMessage());
		}
	}

	public void handleTradeMessage(String msg) {
		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				handleSpecialTrade(msg);
				return "";
			}
		});
		executorService.execute(futureTask);
	}


	/**
	 * 判断是否为送卡密商品并进行一系列操作
	 * @param msg
	 */
	@Transactional
	public void handleSpecialTrade (String msg) {
		Response response = JSONObject.parseObject(msg, Response.class);
		String outerItemId = response.getFullOrderInfo().getOrders().get(0).getOuterItemId();
		String mobile = response.getFullOrderInfo().getBuyerInfo().getBuyer_phone();

		CertValueInfo certValueInfo = certValueInfoService.findCertValueInfo(outerItemId);
		if (null == certValueInfo) {
			return;
		}

		String value = certValueInfo.getOuterCertCardValue();
		String openid = getOpenidByMobile(mobile);
		sendCertCard(openid, value);

	}


	//通过手机号获取openid
	//todo:更换获取token方法
	private String getOpenidByMobile(String mobile) {
		String url = String.format(YouZanConstants.USERS_URL, ScheduleTask.getYouZanAccessToken(), mobile);
		String result = HttpRequestUtils.httpGet(url);
		YouZanResult userInfo = JSONObject.parseObject(result, YouZanResult.class);
		if (null == userInfo) {
			log.error("{}该手机号未查询到微信openid", mobile);
		}
		return userInfo.getResponse().getOpen_id();
	}
	//调用模板消息发送卡密
	private void sendCertCard(String openid, String value) {
		List<CertCardInfo> list = certCardInfoMapper.selectNotSendListByValue(value);
		if (null == list || list.size() == 0 ) {
			log.error("向{}发送时面值为{}卡密已缺货，请补充------------------------------",openid,value);
		}
		CertCardInfo certCardInfo = list.get(0);
		TemplateMessageUtil.sendCardKeyTemplate(openid, certCardInfo.getSerialNumber(), certCardInfo.getRedeemCode());
		certCardInfo.setIsSend("Y");
		certCardInfoMapper.update(certCardInfo);
		log.info("向{}发送卡密成功", openid);

		//新增发送卡密流水
		CertCardRecord record = new CertCardRecord();
		record.setSerialNumber(certCardInfo.getSerialNumber());
		record.setOpenid(openid);
		certCardRecordMapper.insertByObject(record);
	}


}
