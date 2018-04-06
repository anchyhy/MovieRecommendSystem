package com.lzs.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.BaseDao;

/**
 * 
 * @ClassName: BaseService
 * 
 * @param <T>
 */
@Service
@Transactional
public class BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	public Serializable save(T o) {

		return baseDao.save(o);
	}

	public void delete(T o) {
		baseDao.delete(o);

	}

	public void update(T o) {

		baseDao.update(o);
	}

	public void saveOrUpdate(T o) {

		baseDao.saveOrUpdate(o);
	}

	public List<T> find(String hql) {

		return baseDao.find(hql);
	}

	public List<T> find(String hql, Object[] param) {

		return baseDao.find(hql, param);
	}

	public List<T> find(String hql, List<Object> param) {

		return baseDao.find(hql, param);
	}

	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {

		return baseDao.find(hql, param, page, rows);
	}

	public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {

		return baseDao.find(hql, param, page, rows);
	}

	public T get(Class<T> c, Serializable id) {

		return (T) baseDao.get(c, id);
	}

	public T get(String hql, Object[] param) {

		return (T) baseDao.get(hql, param);
	}

	public T get(String hql, List<Object> param) {

		return (T) baseDao.get(hql, param);
	}

	public Long count(String hql) {

		return baseDao.count(hql);
	}

	public Long count(String hql, Object[] param) {

		return baseDao.count(hql, param);
	}

	public Long count(String hql, List<Object> param) {

		return baseDao.count(hql, param);
	}

	public Integer executeHql(String hql) {

		return baseDao.executeHql(hql);
	}

	public Integer executeHql(String hql, Object[] param) {

		return baseDao.executeHql(hql, param);
	}

	public Integer executeHql(String hql, List<Object> param) {

		return baseDao.executeHql(hql, param);
	}
	
	public Double average(String hql){
		return baseDao.average(hql);
	}
	
	public Double average(String hql, Object[] param){
		return baseDao.average(hql, param);
	}
	
	public Double average(String hql, List<Object> param){
		return baseDao.average(hql, param);
	}

}
