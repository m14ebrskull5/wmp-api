package com.wmp.api.card.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmp.api.card.entity.Card;
import com.wmp.api.card.service.CardService;
import com.wmp.common.base.controller.AbstractBaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: CardController
 * @Description: TODO(名片信息接口)
 * @author chenaonan
 * @date 2018年8月17日 下午5:28:00
 */
@Api(value = "", tags = "名片信息接口")
@RestController
public class CardController extends AbstractBaseController {
	
	
	@Inject
	private CardService cardService;
	
	@GetMapping(value = "/v1/card/{id}")
	@ApiOperation(value = "获取名片信息", notes = "通过名片Id获取名片信息")
	@ApiImplicitParam(dataType = "String", name = "id", value = "名片Id", required = true, paramType="query")
	public Card card(@RequestParam(value = "id") Integer id, HttpSession session) {
		Card card = cardService.findById(id);
		return card;
	}
}