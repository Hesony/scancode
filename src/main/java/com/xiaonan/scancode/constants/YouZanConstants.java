package com.xiaonan.scancode.constants;

public class YouZanConstants {

	/**有赞应用ID */

	public static final String YOUZAN_CLIENT_ID = "7d232e3ba7dc672366";
	/**有赞应用SECRET */

	public static final String YOUZAN_CLIENT_SECRET = "56f84d98769a06c8eb472a7d22072007";
	/**授权店铺ID */

	public static final String YOUZAN_KTD_ID = "40967764";

	/**获取token */

	public static final String ACCESS_TOKEN_URL = "https://open.youzan.com/oauth/token?client_id=%s&client_secret=%s&grant_type=silent&kdt_id=%s";

	/**获取电子卡券信息 url */

	public static final String GET_VERIFYTICKET_URL = "https://open.youzan.com/api/oauthentry/youzan.trade.virtualticket/3.0.0/get?access_token=%s&code=%s";

	/** 电子卡券单个码券核销 url */

	public static final String VERIFYTICKET_URL = "https://open.youzan.com/api/oauthentry/youzan.trade.virtualticket/3.0.0/verifyticket?access_token=%s&ticket_code=%s";

	/** 交易订单详情4.0接口 url */

	public static final String TRADE_URL = "https://open.youzan.com/api/oauthentry/youzan.trade/4.0.0/get?access_token=%s&tid=%s";

	/** 根据手机号获取用户信息(包括userid) url */
	public static final String USERS_URL ="https://open.youzan.com/api/oauthentry/youzan.user.weixin.openid/3.0.0/get?access_token=%s&mobile=%s";

}
