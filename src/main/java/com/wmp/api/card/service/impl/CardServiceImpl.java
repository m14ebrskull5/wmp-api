package com.wmp.api.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmp.api.card.dao.CardDao;
import com.wmp.api.card.entity.Card;
import com.wmp.api.card.service.CardService;
/**
 * @author chenaonan
 * @date 2018年8月17日 下午5:30:38
 */
@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardDao cardDao;

	@Override
	public Card findById(Integer id) {
		Card card = cardDao.findById(id);
		return card;
	}

}
