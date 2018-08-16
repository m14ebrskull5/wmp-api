package com.wmp.api.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wmp.api.common.util.redis.RedisUtils;
import com.wmp.api.sys.manager.LoginManager;

/**
 * @ClassName: LoginController
 * @Description: TODO(登录接口)
 * @author chenaonan
 * @date 2018年8月8日 上午11:50:33
 */
@Api(value = "/", tags = "登入接口")
@RestController
public class LoginController {

	@Autowired
	private LoginManager loginManager;
	
	@Resource
    private RedisUtils jedisServer;
	
    @ApiOperation(value="登录凭证校验", notes="获取openId,session_key")
    @RequestMapping(value="/token" ,method= RequestMethod.GET)
	@ApiImplicitParam(dataType = "String", name = "code", value = "登录时获取的 code", required = true, paramType="query")
    public String greeting(@RequestParam(value="code") String code, HttpSession session) {
    	String response = loginManager.getToken(code, session);
        return response;
    }
    
    @ApiOperation(value="通过token获取息", notes="通过token获取息")
    @RequestMapping(value="/getSessionKey" ,method= RequestMethod.GET)
    @ApiImplicitParam(dataType = "String", name = "token", value = "通过token获取息", required = true, paramType="query")
    public String getToken(@RequestParam(value="token") String token, HttpSession session) {
    	String data = jedisServer.get(token);
    	return data;
    }

}