package com.wmp.api.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmp.api.card.entity.Card;
import com.wmp.api.login.service.LoginService;
import com.wmp.common.base.controller.AbstractBaseController;
import com.wmp.common.constants.BaseConstants;
import com.wmp.common.util.HttpRequestUtil;
import com.wmp.common.util.UuidUtils;
import com.wmp.common.util.redis.RedisUtils;

@Service
public class LoginServiceImpl implements LoginService{
	
	protected static Logger logger = Logger.getLogger(AbstractBaseController.class);
	
    @Resource
    private RedisUtils jedisServer;

	/**
	 * @Title: getToken
	 * @Description: TODO(获取用户登录标示)
	 * @param @param code
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getToken(String code, HttpSession session) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("js_code", code);
		params.put("appid", BaseConstants.APPID);
		params.put("secret", BaseConstants.APPSECRET);
		params.put("grant_type", BaseConstants.GRANT_TYPE);
		String data = null;
		try {
			data = HttpRequestUtil.httpURLConectionGET(BaseConstants.WEI_XIN_TOKEN_URL, params);
			 if(data.indexOf("openid") != -1) {
				 JSONObject json = JSON.parseObject(data);
				 json.remove("expires_in");
				 String key = UuidUtils.getUUID();
				 Long time = jedisServer.set(key, json.toString(), BaseConstants.REDIS_EXPIRE_TIME);
				 if(time > 0) {
					 JSONObject jsonToken = new JSONObject();
					 jsonToken.put("token", key);
					 session.setAttribute("user",  new Card(json.get("openid").toString()));
					 return jsonToken.toString();
				 }
			 }else {
				 return data;
			 }
		} catch (Exception e) {
			logger.error(e.toString());
			new RuntimeException();
		}
		return null;
	}

	
	public String getSession(String token) {
		try {
			String response = jedisServer.get(token);
			return response;
		} catch (Exception e) {
			logger.error(e.toString());
			new RuntimeException();
		}
		return null;
	}

	/**
	 * @Title: getSession
	 * @Description: TODO(用户授权)
	 * @param @param token
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public boolean toAuthorize(String token) {
		boolean flag = false;
		try {
			Long ttl = jedisServer.ttl(token);
			if(ttl > 0) {
				flag = true;
			}
		} catch (Exception e) {
			logger.error(e.toString());
			new RuntimeException();
		}
		return flag;
	}
	

}
