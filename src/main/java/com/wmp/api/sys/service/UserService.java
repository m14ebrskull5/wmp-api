package com.wmp.api.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.wmp.api.common.base.dao.GenericDao;
import com.wmp.api.common.base.service.GenericService;
import com.wmp.api.sys.dao.UserDao;
import com.wmp.api.sys.entity.QueryUser;
import com.wmp.api.sys.entity.User;


/**
 *@author chenaonan
 **/
@Service("userService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class UserService extends GenericService<User, QueryUser> {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	protected GenericDao<User, QueryUser> getDao() {
		return userDao;
	}
	
	public User findById(Integer id) {
		User user = userDao.findById(id);
		return user;
	}
}