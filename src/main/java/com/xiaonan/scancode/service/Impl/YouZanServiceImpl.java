package com.xiaonan.scancode.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.dao.ShopCommodity;
import com.xiaonan.scancode.dao.ShopInfo;
import com.xiaonan.scancode.dao.StaffInfo;
import com.xiaonan.scancode.dao.VerifyLog;
import com.xiaonan.scancode.model.models.ResultVO;
import com.xiaonan.scancode.model.models.ShopCommodityModel;
import com.xiaonan.scancode.model.models.TicketRecord;
import com.xiaonan.scancode.model.result.YouZanResult;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import com.xiaonan.scancode.service.YouZanService;
import com.xiaonan.scancode.utils.HttpRequestUtils;
import com.xiaonan.scancode.utils.TemplateMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class YouZanServiceImpl implements YouZanService {

	private static String NOT_VERIFY = "NOT_VERIFY";

	@Autowired
	private VerifyLogServiceImpl verifyLogService;
	@Autowired
	private ShopCommodityServiceImpl shopCommodityService;
	@Autowired
	private StaffServiceImpl staffService;



	@Override
	public YouZanResult getVerifyTicket(String scancode) {
		try {
			log.info("本次获取的二维码券码为：{}", scancode);
			String param = "access_token=" + ScheduleTask.getYouZanAccessToken() +"&code=" + scancode;
			String url = String.format(YouZanConstants.GET_VERIFYTICKET_URL, ScheduleTask.getYouZanAccessToken(), scancode);
			String resultJson = HttpRequestUtils.httpGet(url);
			YouZanResult result = JSONObject.parseObject(resultJson, YouZanResult.class);
			log.info("获取电子卡券信息为：{}", resultJson);
			return result;
//			return result.getResponse().getTickets();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public ResultVO verifyTicket(YouZanResult youZanResult, String openid) {
		ResultVO resultVO = new ResultVO();
		List<TicketRecord> list = youZanResult.getResponse().getTickets();
		if (null == list || list.size() == 0) {
			log.info("无可核销订单，请顾客确认");
			resultVO.setCode("001");
			resultVO.setMsg("无可核销订单，请顾客确认");
			return resultVO;
		}
		//订单号
		String tid = youZanResult.getResponse().getTid();
		//二维码扫出的号
		String scancode = youZanResult.getResponse().getCode();

		//判断有此商品编码的店铺下是否有此核销员openid
		if (!judge(tid, openid)) {
			resultVO.setCode("001");
			resultVO.setMsg("您非该店铺核销员，请关闭页面");
			return resultVO;
		}

		//获取电子券码的商品编号
		String trade_url = String.format(YouZanConstants.TRADE_URL, ScheduleTask.getYouZanAccessToken(), tid);
		YouZanResult trade_result = JSONObject.parseObject(HttpRequestUtils.httpGet(trade_url), YouZanResult.class);
		String outerItemId = trade_result.getResponse().getFullOrderInfo().getOrders().get(0).getOuterItemId();

		//获取商品名称
		String title = trade_result.getResponse().getFullOrderInfo().getOrders().get(0).getTitle();
		String price = trade_result.getResponse().getFullOrderInfo().getOrders().get(0).getPrice();

		//获取对应商品编号的商品名称
		ShopCommodity shopCommodity = shopCommodityService.selectShopCommodityByItemId(outerItemId);
		if (null == shopCommodity) {
			log.info("请查看商品编码{}是否在预期店铺下出现,或者不同店铺存在相同商品编码", outerItemId);
			resultVO.setCode("001");
			resultVO.setMsg("核销失败，请联系管理员");
			return resultVO;
		}
		String goodsTitle = shopCommodity.getGoodsTitle();

		//未核销的电子券码列表
		List<String> ticketList = new ArrayList<>(16);
		for (TicketRecord record: list) {
			if (NOT_VERIFY.equals(record.getTicket_state())) {
				ticketList.add(record.getTicket_code());
			}
		}
		if (ticketList.size() > 0 && ticketList != null) {
			//这里如果未核销的电子券码个数不为0，则核销第一个券
			String ticket = ticketList.get(0);
			String url = String.format(YouZanConstants.VERIFYTICKET_URL, ScheduleTask.getYouZanAccessToken(), ticket);
			String resultJson = HttpRequestUtils.httpGet(url);
			YouZanResult result = JSONObject.parseObject(resultJson, YouZanResult.class);
			log.info("请求有赞接口结束：" + openid +"此次核销的电子券码为：{}",ticket);
			VerifyLog verifyLog = new VerifyLog();
			verifyLog.setOpenid(openid);
			verifyLog.setTicketCode(ticket);
			verifyLog.setTid(tid);
			verifyLog.setScanCode(scancode);
			verifyLog.setOuterItemId(outerItemId);
			verifyLog.setGoodsTitle(goodsTitle);
			verifyLogService.insertVerifyLog(verifyLog);
			//如果成功，返回 "true"
			log.info("核销电子券码结果为: {}" ,resultJson);

			//发送核销成功模板消息
			TemplateMessageUtil.sendVerifyTemplate(openid, title, price);

			resultVO.setCode("000");
			resultVO.setMsg("核销成功，请关闭页面");
			return resultVO;
		} else if (ticketList.size() == 0 || ticketList == null) {
			log.info("该电子券码已被核销，请用户确认");
			resultVO.setCode("001");
			resultVO.setMsg("该电子券码已被核销，请用户确认");
			return resultVO;
		}
		return resultVO;
	}


	//判断有此商品编码的店铺下是否有此核销员openid↑
	private Boolean judge(String tid, String openid) {
		String trade_url = String.format(YouZanConstants.TRADE_URL, ScheduleTask.getYouZanAccessToken(), tid);
		YouZanResult trade_result = JSONObject.parseObject(HttpRequestUtils.httpGet(trade_url), YouZanResult.class);
		String outerItemId = trade_result.getResponse().getFullOrderInfo().getOrders().get(0).getOuterItemId();
		log.info("订单号{}此次核销的电子券码的商品编码为：{}", tid, outerItemId);
		ShopCommodity shopCommodity = new ShopCommodity();
		try {
			shopCommodity = shopCommodityService.selectShopCommodityByItemId(outerItemId);
		} catch (Exception e) {
			log.info("查询出错，请查看商品编码{}是否在预期店铺下出现,或者不同店铺存在相同商品编码",outerItemId);
			return false;
		}
		String shopIdCommodity = shopCommodity.getShopId();
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = staffService.selectByOpenid(openid);
		String shopIdStaff = staffInfo.getShopId();
		if (shopIdCommodity.equals(shopIdStaff)) {
			return true;
		}else {
			return false;
		}
	}

}
