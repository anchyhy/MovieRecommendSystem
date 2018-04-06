package com.lzs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lzs.model.Rating;

@Repository
public class RatingDao extends BaseDao<Rating> {
	public double getAverageByMovie(long mid){
		Object[] param = {mid};
		return this.average("select avg(rate) from Rating where mid = ?", param);
	}

	public double getAverageByUser(long uid){
		Object[] param = {uid};
		return this.average("select avg(rate) from Rating where uid = ?", param);
	}
	
	public List<Rating> getRatingByUser(long uid){
		Object[] param = {uid};
		return this.find("from Rating where uid = ?", param);
	}
	
	public List<Rating> getRatingByMovie(long mid){
		Object[] param = {mid};
		return this.find("from Rating where mid = ?", param);
	}
	public Rating getRatingByUM(long mid, long uid) {
		Object[] param={mid, uid};
//		return this.find("from Rating where mid=? and uid=?", param).iterator().next();
		List<Rating> ratings = this.find("from Rating where mid=? and uid=?", param);
		if(ratings.size() == 0)
			return null;
		return ratings.iterator().next();
	}
	
}
