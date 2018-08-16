package com.wmp.api.common.constants;

public interface BaseConstants {

	//小程序APPID
	static final String APPID = "wx462093082db24967";
	
	//小程序APPSECRET
	static final String APPSECRET = "facb22c49525c6a66bca793efbdd09c6";
	
	static final String GRANT_TYPE = "authorization_code";
	
	static final String WEI_XIN_TOKEN_URL = "https://api.weixin.qq.com/sns/jscode2session?";
	
	//设置redis中用户session_key过期时间为5400s
	static final Integer REDIS_EXPIRE_TIME = 5400;
}
