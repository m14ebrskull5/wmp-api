package com.wmp.api.sys.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmp.api.common.base.controller.GenericController;
import com.wmp.api.common.base.service.GenericService;
import com.wmp.api.sys.entity.QueryUser;
import com.wmp.api.sys.entity.User;
import com.wmp.api.sys.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *@author chenaonan
 **/
@Api(value = "API - UserController", tags = "用户信息接口")
@RestController
public class UserController extends GenericController<User, QueryUser> {
	
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	
	@Inject
	private UserService userService;
	@Autowired
    private Environment env;
	@Override
	protected GenericService<User, QueryUser> getService() {
		return userService;
	}
	
	@ApiOperation(value = "获取用户信息", notes = "通过openid获取用户信息")
	@RequestMapping(value = "/v1/users", method = RequestMethod.GET)
	public String getUsersById(@RequestParam(value = "id", defaultValue = "736") Integer id, HttpSession session) {
		//User user2 = userService.findById(id);
		//users.put(id.longValue(), user2);
		return env.getProperty("server.port");
	}
}