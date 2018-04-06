package com.lzs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.RatingDao;
import com.lzs.model.Rating;

@Service
@Transactional
public class RatingService extends BaseService<Rating> {

	@Autowired
	private RatingDao ratingDao;

	public double getAverageByMovie(long mid) {
		return ratingDao.getAverageByMovie(mid);
	}

	public double getAverageByUser(long uid) {
		return ratingDao.getAverageByUser(uid);
	}

	public List<Rating> getRatingByUser(long uid) {
		return ratingDao.getRatingByUser(uid);
	}

	public List<Rating> getRatingByMovie(long mid) {
		return ratingDao.getRatingByMovie(mid);
	}
	public Rating getRatingByUM(long mid, long uid) {
		return ratingDao.getRatingByUM(mid, uid);
	}

}
