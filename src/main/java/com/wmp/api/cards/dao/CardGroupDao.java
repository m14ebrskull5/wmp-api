package com.wmp.api.cards.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmp.api.cards.entity.CardGroup;
/**
 * @ClassName: CardGroupDao
 * @Description: TODO(名片夹Dao)
 * @author chenaonan
 * @date 2018年8月17日 下午4:58:38
 */
public interface CardGroupDao extends JpaRepository<CardGroup,Integer>{

}
