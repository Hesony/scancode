package com.xiaonan.scancode.scheduleJob;

import com.xiaonan.scancode.constants.WeiXinConstants;
import com.xiaonan.scancode.constants.YouZanConstants;
import com.xiaonan.scancode.utils.SpiderUtils;
import com.xiaonan.scancode.utils.WeiXinUtil;
import com.xiaonan.scancode.utils.YouZanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时加载类
 */
@Slf4j
@Component
public class ScheduleTask implements InitializingBean {
	private final ScheduledThreadPoolExecutor STPE_WX = new ScheduledThreadPoolExecutor(1);

	private final ScheduledThreadPoolExecutor STPE_YZ = new ScheduledThreadPoolExecutor(1);

	private final ScheduledThreadPoolExecutor STPE_LK = new ScheduledThreadPoolExecutor(1);

	/** 配置刷新时间 单位：（秒） */
	private static long weiXinPeriod = 7000;

	/** 配置刷新时间 单位：（天） */
	private static long youZanPeriod = 1;

	/** 配置刷新时间 单位：（小时） */
	private static long lukuangPeriod = 1;


	private static String weiXinAccessToken;

	private static String ticket;

	private static String youZanAccessToken;

	//路况信息
	private static List<String> roadContent;


	public static List<String> getRoadContent() {
		return roadContent;
	}

	public static void setRoadContent(List<String> roadContent) {
		ScheduleTask.roadContent = roadContent;
	}

	public static String getWeiXinAccessToken() {
		return weiXinAccessToken;
	}

	public static void setWeiXinAccessToken(String weiXinAccessToken) {
		ScheduleTask.weiXinAccessToken = weiXinAccessToken;
	}

	public static String getTicket() {
		return ticket;
	}

	public static void setTicket(String ticket) {
		ScheduleTask.ticket = ticket;
	}

	public static String getYouZanAccessToken() {
		return youZanAccessToken;
	}

	public static void setYouZanAccessToken(String youZanAccessToken) {
		ScheduleTask.youZanAccessToken = youZanAccessToken;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		STPE_WX.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				/**
				 * 定时获取accessToken并存到内存
				 */
				log.info("获取获取到最新的accessToken开始...");
				try {

					String accessTokenNew = WeiXinUtil.getAccessToken();
					weiXinAccessToken = accessTokenNew;
					log.info("获取到最新的微信accessToken为：{}", weiXinAccessToken);
				} catch (Exception e) {
					e.printStackTrace();
					log.error("获取获取到最新的微信accessToken异常");
				}

				log.info("获取获取到最新的微信ticket开始...");
				try {
					String ticketNew = WeiXinUtil.getJsApiTicket(weiXinAccessToken);
					ticket = ticketNew;
					log.info("获取到最新的微信ticket为：{}", ticket);
				} catch (Exception e) {
					e.printStackTrace();
					log.error("获取获取到最新的微信ticket异常");
				}
			}
		},0,weiXinPeriod, TimeUnit.SECONDS);

		STPE_YZ.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				try {
					String accessTokenNew = YouZanUtil.getAccessToken();
					youZanAccessToken = accessTokenNew;
					log.info("获取到最新的有赞accessToken为：{}", youZanAccessToken);
				} catch (Exception e) {
					e.printStackTrace();
					log.error("获取最新的有赞accessToken异常");
				}

			}
		}, 0,youZanPeriod, TimeUnit.DAYS);

		STPE_LK.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				try {
					log.info("获取最新路况信息开始...");
					List<String> newList = SpiderUtils.roadMessage();
					roadContent = newList;
					log.info("获取路况信息结束,条数:{}", roadContent.size());
				}catch (Exception e) {
					log.error("获取路况信息失败");
				}
			}
		},0, lukuangPeriod, TimeUnit.HOURS);
	}

}
