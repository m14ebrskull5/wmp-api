package com.wmp.api.sys.dao;

import com.wmp.api.common.base.dao.GenericDao;
import com.wmp.api.sys.entity.QueryUser;
import com.wmp.api.sys.entity.User;

/**
 *@author chenaonan
 **/
public interface UserDao extends GenericDao<User, QueryUser> {

	User findById(Integer id);
}