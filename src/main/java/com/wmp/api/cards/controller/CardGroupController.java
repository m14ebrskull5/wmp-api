package com.wmp.api.cards.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmp.api.card.entity.Card;
import com.wmp.api.cards.service.CardGroupService;
import com.wmp.common.base.controller.AbstractBaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
/**
 * @ClassName: CardGroupController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenaonan
 * @date 2018年8月17日 下午4:55:55
 */
@Api(value = "", tags = "名片夹信息接口")
@RestController
public class CardGroupController extends AbstractBaseController{
	
	@Autowired
	private CardGroupService cardGroupService;
	
	@GetMapping(value = "/v1/users")
	@ApiOperation(value = "获取用户信息", notes = "通过openid获取用户信息")
	@ApiImplicitParam(dataType = "String", name = "id", value = "用户Id", required = true, paramType="query")
	public List<Card> getUsersById(@RequestParam(value = "id") Integer id, HttpSession session) {
		List<Card> list = cardGroupService.cards(id);
		return list;
	}

}
