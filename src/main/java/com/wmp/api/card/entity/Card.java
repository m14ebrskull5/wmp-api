package com.wmp.api.card.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenaonan
 * @date 2018年8月17日 下午5:30:58
 */
@Entity
@Table(name = "WMP_USERS")
@ApiModel(value="名片对象模型")
public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "名片ID")
	private Integer id;
	
	@Column(name = "OPENID")
	@ApiModelProperty(value = "用户OpenId")
	private String openid;
	
	@ApiModelProperty(value = "用户头像")
	private String userpic;
	
	@ApiModelProperty(value = "用户姓名")
	private String name;
	
	@ApiModelProperty(value = "用户所属公司")
	private String company;
	
	@ApiModelProperty(value = "用户工作")
	private String job;
	
	@ApiModelProperty(value = "用户手机号码-1")
	private String mophone1;
	
	@ApiModelProperty(value = "用户手机号码-2")
	private String mophone2;
	
	@ApiModelProperty(value = "用户手机号码-3")
	private String mophone3;
	
	@ApiModelProperty(value = "用户电话号码-1")
	private String phone1;
	
	@ApiModelProperty(value = "用户电话号码-2")
	private String phone2;
	
	@ApiModelProperty(value = "用户电话号码-3")
	private String phone3;
	
	@ApiModelProperty(value = "用户地址-1")
	private String addr1;
	
	@ApiModelProperty(value = "用户地址-2")
	private String addr2;
	
	@ApiModelProperty(value = "用户地址-3")
	private String addr3;
	
	@ApiModelProperty(value = "用户邮箱-1")
	private String email1;
	
	@ApiModelProperty(value = "用户邮箱-2")
	private String email2;
	
	@ApiModelProperty(value = "公司官网")
	private String website;
	
	@ApiModelProperty(value = "微信号")
	private String wechat;
	
	@ApiModelProperty(value = "传真")
	private String fax;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "公司简介")
	private String intro;
	
	@ApiModelProperty(value = "名片姓名首字母")
	private String pinyin;
	
	@ApiModelProperty(value = "添加时间")
	private String addtimeS;
	
	@ApiModelProperty(value = "名片顺序")
	private Integer order;
	
	@ApiModelProperty(value = "表单token")
	private String formtoken;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMophone1() {
		return mophone1;
	}

	public void setMophone1(String mophone1) {
		this.mophone1 = mophone1;
	}

	public String getMophone2() {
		return mophone2;
	}

	public void setMophone2(String mophone2) {
		this.mophone2 = mophone2;
	}

	public String getMophone3() {
		return mophone3;
	}

	public void setMophone3(String mophone3) {
		this.mophone3 = mophone3;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getAddtimeS() {
		return addtimeS;
	}

	public void setAddtimeS(String addtimeS) {
		this.addtimeS = addtimeS;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getFormtoken() {
		return formtoken;
	}

	public void setFormtoken(String formtoken) {
		this.formtoken = formtoken;
	}

	public Card() {
		super();
	}

	public Card(String openid) {
		super();
		this.openid = openid;
	}

	public Card(Integer id, String openid, String userpic, String name, String company, String job, String mophone1,
			String mophone2, String mophone3, String phone1, String phone2, String phone3, String addr1, String addr2,
			String addr3, String email1, String email2, String website, String wechat, String fax, String remark,
			String intro, String pinyin, String addtimeS, Integer order, String formtoken) {
		super();
		this.id = id;
		this.openid = openid;
		this.userpic = userpic;
		this.name = name;
		this.company = company;
		this.job = job;
		this.mophone1 = mophone1;
		this.mophone2 = mophone2;
		this.mophone3 = mophone3;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.email1 = email1;
		this.email2 = email2;
		this.website = website;
		this.wechat = wechat;
		this.fax = fax;
		this.remark = remark;
		this.intro = intro;
		this.pinyin = pinyin;
		this.addtimeS = addtimeS;
		this.order = order;
		this.formtoken = formtoken;
	}
	
	
}
