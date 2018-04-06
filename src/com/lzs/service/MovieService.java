package com.lzs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.MovieDao;
import com.lzs.model.Movie;

@Service
@Transactional
public class MovieService extends BaseService<Movie> {

	@Autowired
	private MovieDao movieDao;

	public List<Movie> getMoviesByClassification(String classfication, int pageNum, int pageSize) {
		return movieDao.getMoviesByClassification(classfication, pageNum, pageSize);
	}

	public List<Object> getInfo(String hql, Object[] param){
		return movieDao.getInfo(hql, param);
	}
	
	public List<Object> getInfo(String hql, Object[] param, Integer page, Integer rows){
		return movieDao.getInfo(hql, param, page, rows);
	}
}
