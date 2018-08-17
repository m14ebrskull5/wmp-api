package com.wmp.api.card.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wmp.api.card.entity.Card;

/**
 * @author chenaonan
 * @date 2018年8月17日 下午5:30:49
 */
public interface CardDao extends JpaRepository<Card,Integer> {

	@Query("select c from Card c where c.id = :id")
	Card findById(@Param("id")Integer id);
}