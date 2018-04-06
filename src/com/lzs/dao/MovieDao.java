package com.lzs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lzs.model.Movie;

@Repository
public class MovieDao extends BaseDao<Movie> {
	public List<Movie> getMoviesByClassification(String classfication, int pageNum, int pageSize) {
		Object[] param = {};
		return this.find("from Movie where " + classfication +" = true", param, pageNum, pageSize);
	}

}
