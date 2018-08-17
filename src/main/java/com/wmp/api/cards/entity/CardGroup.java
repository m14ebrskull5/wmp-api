package com.wmp.api.cards.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wmp.api.card.entity.Card;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "WMP_USER_RELATION")
@ApiModel(value="名片夹模型")
public class CardGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "名片夹Id")
	private Integer id;
	
	@Column(name = "WMP_USER_OPENID")
	@ApiModelProperty(value = "用户OpenId")
	private String openId;
	
	@Column(name = "WMP_USER_ID")
	@ApiModelProperty(value = "发送名片的名片Id")
	private Integer cardId;
	
	@Column(name = "ADDTIME")
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@Column(name = "ADDTIME_S")
	@ApiModelProperty(value = "名片收取时间")
	private String receiveDate;
	
	@Column(name = "SHAREOTHERS")
	@ApiModelProperty(value = "收取名片的场景")
	private String scene;
	
	@Column(name = "ISREAD")
	@ApiModelProperty(value = "是否已读")
	private String isRead;
	
	@JsonIgnore
    private Set<Card> card;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public CardGroup() {
		super();
	}

	public CardGroup(Integer id, String openId, Integer cardId, String remark, String receiveDate, String scene,
			String isRead) {
		super();
		this.id = id;
		this.openId = openId;
		this.cardId = cardId;
		this.remark = remark;
		this.receiveDate = receiveDate;
		this.scene = scene;
		this.isRead = isRead;
	}
	

}
