package com.wmp.api.common.base.dao;
import java.util.List;

import com.wmp.api.common.base.entity.QueryBase;


/**
 * @ClassName: GenericDao
 * @Description: TODO(Dao通用模版)
 * @author chenaonan
 * @date 2018年8月8日 上午11:22:14
 * @param <T>
 * @param <Q>
 */
public interface GenericDao<T, Q extends QueryBase>{
	/**
	 * 根据主键值获取对象
	 * @param entity
	 * */
	public T get(T entity);
	
	/**
	 * 获取全部实体
	 * */
    public List<T> loadAll();

	/**
	 * 查找是否存在
	 * @param queryModel 查询条件
	 * @return int
	 * */
	public int isExist(Q queryModel);

	/** 
	 * 保存
	 * @param entity 保存对象
	 * @return int
	 * @throws Exception
	 * */
	public int save(T entity) throws Exception;

	/** 
	 * 更新 
	 * @param entity 修改对象
	 * @return int
	 * @throws Exception
	 * */
	public int update(T entity) throws Exception;

	/**
	 * 删除 
	 * @param entity 删除对象
	 * @throws Exception
	 * @return int
	 * */
	public int delete(T entity) throws Exception;

	/**
	 * 分页查询
	 * @param queryModel 查询条件
	 *  */
	public List<T> findByPage(Q queryModel);
	
	/**
	 * 统计
	 * @param queryModel 查询条件
	 * @return int
	 * */
	public int count(Q queryModel);

	/**
	 * 查询
	 * @param queryModel 查询条件
	 *  */
	public List<T> query(Q queryModel);
	/**
	 * 根据id数组删除记录
	 * @param ids 数组
	 * @return int
	 * */
	public int deleteByIds(String[] ids) throws Exception;
}