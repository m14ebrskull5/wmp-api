package com.wmp.api.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wmp.api.login.service.LoginService;
import com.wmp.common.base.controller.AbstractBaseController;

/**
 * @ClassName: LoginController
 * @Description: TODO(登录接口)
 * @author chenaonan
 * @date 2018年8月8日 上午11:50:33
 */
@Api(value = "/", tags = "登入接口")
@RestController
public class LoginController extends AbstractBaseController{

	@Autowired
	private LoginService loginService;
	
	@GetMapping(value="/v1/token")
    @ApiOperation(value="用户登录凭证校验", notes="用户登录凭证校验")
	@ApiImplicitParam(dataType = "String", name = "code", value = "微信登录code码", required = true, paramType="query")
    public String token(@RequestParam(value="code") String code, HttpSession session) {
    	String response = loginService.getToken(code, session);
        return response;
    }
    
	@GetMapping(value="/v1/session")
    @ApiOperation(value="获取用户SessionKey,openId", notes="获取用户SessionKey,openId")
    @ApiImplicitParam(dataType = "String", name = "token", value = "用户登录凭证校验返回的token", required = true, paramType="query")
    public String session(@RequestParam(value="token") String token, HttpSession session) {
    	String response = loginService.getSession(token);
    	return response;
    }

}