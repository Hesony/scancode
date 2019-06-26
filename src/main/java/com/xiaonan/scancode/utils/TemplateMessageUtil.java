package com.xiaonan.scancode.utils;

import com.xiaonan.scancode.constants.WeiXinConstants;
import com.xiaonan.scancode.scheduleJob.ScheduleTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMessageUtil {

	/** 发送核销成功模板消息 */
	public static void sendVerifyTemplate(String openid, String title, String price) {
		String url = String.format(WeiXinConstants.TEMPLATE_URL, ScheduleTask.getWeiXinAccessToken());
		String verifyTempleateId = "ciRna7QwULD8Nz5lyQPwIDJgvtpmxB7hBZEAMrxrY2I";
		String time = DateUtil.nowTime();
		String param = "{\n" +
				"           \"touser\":\"" + openid + "\",\n" +
				"           \"template_id\":\"" + verifyTempleateId + "\",\n" +
				"           \"data\":{\n" +
				"                   \"first\": {\n" +
				"                       \"value\":\"核销成功\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword1\":{\n" +
				"                       \"value\":\"" + time + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword2\": {\n" +
				"                       \"value\":\"" + title + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword3\": {\n" +
				"                       \"value\":\"" + price + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"remark\":{\n" +
				"                       \"value\":\"祝您生活愉快！\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   }\n" +
				"           }\n" +
				"       }";
		log.info("{}核销成功发送模板内容：{}", openid, param);
		HttpRequestUtils.httpPost(url, param);
	}

	public static void sendCardKeyTemplate(String openid, String card, String key) {
		String url = String.format(WeiXinConstants.TEMPLATE_URL, ScheduleTask.getWeiXinAccessToken());
		String verifyTempleateId = "MZZeVjuKbTOgXMcmPeCEfINvsbUPyP8EDoKNGpOot8s";
		String time = DateUtil.nowTime();
		String param = "{\n" +
				"           \"touser\":\"" + openid + "\",\n" +
				"           \"template_id\":\"" + verifyTempleateId + "\",\n" +
				"           \"data\":{\n" +
				"                   \"first\": {\n" +
				"                       \"value\":\"" + time + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword1\":{\n" +
				"                       \"value\":\"" + card + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword2\": {\n" +
				"                       \"value\":\"" + key + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword3\": {\n" +
				"                       \"value\":\"" + key + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"remark\":{\n" +
				"                       \"value\":\"祝您生活愉快！\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   }\n" +
				"           }\n" +
				"       }";
		log.info("向{}卡密成功发送模板内容：{}", openid, param);
		HttpRequestUtils.httpPost(url, param);
	}

	public static void sendCardKeyTemplateTest(String openid, String card, String key) {
		String url = String.format(WeiXinConstants.TEMPLATE_URL,
				"22_nbiLeMz3ORe2ERxZ-41JicFzQuuC9yOf32ytMol07bamQD9b-zJxVMoJyckeUIinfw7sdDuiTp68gp4VAYeIxSJynrCWTLkw6GwPn17KrR1rQ6KYK1PhHv4zWsAtrT4PpvydT6JQHkybOdA6WREeAAAHCP");
		String time = DateUtil.nowTime();
		String verifyTempleateId = "MZZeVjuKbTOgXMcmPeCEfINvsbUPyP8EDoKNGpOot8s";
		String param = "{\n" +
				"           \"touser\":\"" + openid + "\",\n" +
				"           \"template_id\":\"" + verifyTempleateId + "\",\n" +
				"           \"data\":{\n" +
				"                   \"first\": {\n" +
				"                       \"value\":\"" + time + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword1\":{\n" +
				"                       \"value\":\"" + card + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword2\": {\n" +
				"                       \"value\":\"" + key + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"keyword3\": {\n" +
				"                       \"value\":\"" + key + "\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   },\n" +
				"                   \"remark\":{\n" +
				"                       \"value\":\"祝您生活愉快！\",\n" +
				"                       \"color\":\"#173177\"\n" +
				"                   }\n" +
				"           }\n" +
				"       }";
		log.info("向{}卡密成功发送模板内容：{}", openid, param);
		HttpRequestUtils.httpPost(url, param);
	}


}
