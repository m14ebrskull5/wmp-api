package com.wmp.api.sys.manager;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmp.api.common.constants.BaseConstants;
import com.wmp.api.common.util.ExceptionUtil;
import com.wmp.api.common.util.HttpRequestUtil;
import com.wmp.api.common.util.UuidUtils;
import com.wmp.api.common.util.redis.RedisUtils;
import com.wmp.api.sys.entity.User;

@Service
public class LoginManager {
	
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
					 JSONObject object = new JSONObject();
					 User user = new User();
					 object.put("token", key);
					 user.setOpenid(json.get("openid").toString());
					 session.setAttribute("user", user);
					 System.out.println(object.toString());
					 return key;
				 }
			 }else {
				 return data;
			 }
		} catch (Exception e) {
			ExceptionUtil.getStackTrace(e);
		}
		return null;
	}
	

}
