package com.xiaonan.scancode.constants;

public class WeiXinConstants {

	//微信APPID
	public static final String APP_ID = "wx715facf68de5632b";
	//微信密钥
	public static final String APP_SECERT = "bf77f3e273cf95e6932f3992de15a75c";
	//项目url
	public static final String DEMO_URL = "http://www.ycssx.cn/scancode";
	// "http://xiaonan.mynatapp.cc/scancode";

	public static final String WEIXIN_URL = "https://api.weixin.qq.com/scancode";

	//获取access_token url
	//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	//获取ticket url
	// https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=
	public static final String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

	//oauth2授权的url连接 获取code
	public static final String CONNECT_OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

	//用code换取oauth2的access token
	// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	public static final String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	//拉取用户信息(需scope为 snsapi_userinfo)
	//https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	public static final String SNSAPI_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

	//微信模板消息
	public static final String TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

}
