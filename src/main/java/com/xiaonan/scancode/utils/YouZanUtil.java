package com.xiaonan.scancode.utils;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.model.models.TicketRecord;
import com.xiaonan.scancode.model.result.YouZanResult;
import com.xiaonan.scancode.model.result.YouZanAccessTokenResult;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import com.xiaonan.scancode.service.Impl.VerifyLogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class YouZanUtil {

	private static String NOT_VERIFY = "NOT_VERIFY";

	@Autowired
	private VerifyLogServiceImpl verifyLogService;

	private static YouZanUtil youZanUtil;

	/**
	 * 解决Autowired注入无法在静态方法使用
	 */
	@PostConstruct
	public void init() {
		youZanUtil = this;
		youZanUtil.verifyLogService = this.verifyLogService;
	}

	/**
	 * 获取有赞accesstoken
	 * @return
	 */
	public static String getAccessToken() {
		YouZanAccessTokenResult result = new YouZanAccessTokenResult();
		String url = String.format(YouZanConstants.ACCESS_TOKEN_URL,
				YouZanConstants.YOUZAN_CLIENT_ID,
				YouZanConstants.YOUZAN_CLIENT_SECRET,
				YouZanConstants.YOUZAN_KTD_ID);
		result = JSONObject.parseObject(HttpRequestUtils.httpGet(url), YouZanAccessTokenResult.class);
		String accessToken = result.getAccess_token();
		return accessToken;
	}

//以下均已通过Service注入方式实现
//	/**
//	 * 通过电子卡券二维码的码号(扫用户核销的二维码) 获取电子卡券信息
//	 * @param scancode
//	 * @return
//	 */
//	public static YouZanResult getVerifyTicket(String scancode) {
//
//		try {
//			log.info("本次获取的二维码券码为：{}", scancode);
//			String param = "access_token=" + ScheduleTask.getYouZanAccessToken() +"&code=" + scancode;
//			String url = String.format(YouZanConstants.GET_VERIFYTICKET_URL, ScheduleTask.getYouZanAccessToken(), scancode);
//			String resultJson = HttpRequestUtils.httpGet(url);
//			YouZanResult result = JSONObject.parseObject(resultJson, YouZanResult.class);
//			log.info("获取电子卡券信息为：{}", resultJson);
//			return result;
////			return result.getResponse().getTickets();
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			return null;
//		}
//	}
//
//
//	/**
//	 *电子卡券单个码券核销
//	 * @param youZanResult  获取电子卡券信息结果 ↑
//	 * @param openid
//	 * @return 核销成功返回true，核销失败返回false
//	 */
//	public static String verifyTicket(YouZanResult youZanResult, String openid) {
//		List<TicketRecord> list = youZanResult.getResponse().getTickets();
//		if (null == list || list.size() == 0) {
//			return "false";
//		}
//		//订单号
//		String tid = youZanResult.getResponse().getTid();
//		//二维码扫出的号
//		String scancode = youZanResult.getResponse().getCode();
//
//		List<String> ticketList = new ArrayList<>(16); //未核销的电子券码列表
//		for (TicketRecord record: list) {
//			if (NOT_VERIFY.equals(record.getTicket_state())) {
//				ticketList.add(record.getTicket_code());
//			}
//		}
//		if (ticketList.size() > 0 && ticketList != null) {
//			//这里如果未核销的电子券码个数不为0，则核销第一个券
//			String ticket = ticketList.get(0);
//			String url = String.format(YouZanConstants.VERIFYTICKET_URL, ScheduleTask.getYouZanAccessToken(), ticket);
//			String resultJson = HttpRequestUtils.httpGet(url);
//			YouZanResult result = JSONObject.parseObject(resultJson, YouZanResult.class);
//			log.info("请求有赞接口结束：" + openid +"此次核销的电子券码为：{}",ticket);
//			VerifyLog verifyLog = new VerifyLog();
//			verifyLog.setOpenid(openid);
//			verifyLog.setTicketCode(ticket);
//			verifyLog.setTid(tid);
//			verifyLog.setScanCode(scancode);
//			youZanUtil.verifyLogService.insertVerifyLog(verifyLog);
//			//如果成功，返回 "true"
//			log.info("核销电子券码结果为: {}" ,resultJson);
//			return result.getResponse().getIs_success();
//		} else if (ticketList.size() == 0 || ticketList == null) {
//			log.info("该电子券码已被核销，请用户确认");
//			return "false";
//		}
//		return "false";
//	}
}
