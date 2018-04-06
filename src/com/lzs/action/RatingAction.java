package com.lzs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lzs.model.Movie;
import com.lzs.model.Rating;
import com.lzs.model.User;
import com.lzs.service.MovieService;
import com.lzs.service.RatingService;
import com.lzs.service.UserService;
import com.lzs.trainer.CBTrainer;
import com.lzs.trainer.CFTrainer;
import com.lzs.util.*;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class RatingAction {
	private long id;
	private User user;
	private Movie movie;
	private int rate;
	private long mid;
	private long uid;
	private long mf;
	private int flag;
	private int way;
	private int r;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Autowired
	private RatingService ratingService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public long getMf() {
		return mf;
	}

	public void setMf(long mf) {
		this.mf = mf;
	}

	public int getWay() {
		return way;
	}

	public void setWay(int way) {
		this.way = way;
	}

	public String rate() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("userrate", ratingService.getRatingByUM(mid, uid));
		session.put("movie", movieService.get(Movie.class, mid));
		session.put("rating", ratingService.getAverageByMovie(mid));
		return "rate";
	}

	public String rateMovie() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println(uid+"qqq"+mid);

		Rating rating = new Rating();
		
		rating.setMovie(movieService.get(Movie.class, mid));
		rating.setUser(userService.get(User.class, uid));
		rating.setRate(r);
		ratingService.save(rating);
		session.put("userrate", ratingService.getRatingByUM(mid, uid));
		session.put("movie", movieService.get(Movie.class, mid));
		session.put("rating", ratingService.getAverageByMovie(mid));
		return "ratemovie";
	}

	public String collaborateRating() {
		int i = 1;
		long j = mf;
		Map<Long, Double> map = new HashMap<>();
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<Long, Double> sorted_map = new TreeMap<Long, Double>(bvc);
		CFTrainer cfTrainer = new CFTrainer(ratingService);
		while (i <= 5) {
			// System.out.println(predictRate(uid, j));
			map.put(j, cfTrainer.predictRate(uid, j));
			i++;
			j++;
		}
		sorted_map.putAll(map);
		i = 1;
		System.out.println("length" + sorted_map.size());
		List<Movie> colla_rating_movie = new ArrayList<>();
		for (Long movieid : sorted_map.keySet()) {
			if (i <= 3) {
				i++;
				colla_rating_movie.add(movieService.get(Movie.class, movieid));
				System.out.println("mid" + movieid);
			}
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("flag", flag);
		session.put("mf", mf);
		session.put("movieList", colla_rating_movie);
		session.put("way", way);
		return "collaborateRating";
	}

	public String cbRating() {
		int i = 1;
		// long[] mList = ratingBiz.getMovieNotRatedByUser(uid, mf, 5);
		List<Object> mList = movieService.getInfo(
				"select id from Movie where id not in (select movie.id from Rating where user.id = ?)",
				new Object[] { uid }, (int) mf / 5 + 1, 5);
		Map<Long, Double> map = new HashMap<>();
		CBTrainer cbTrainer = new CBTrainer(ratingService, userService, movieService);
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<Long, Double> sorted_map = new TreeMap<Long, Double>(bvc);
		while (i <= 5) {
			long movieID = Long.parseLong(mList.get(i - 1).toString());
			System.out.println("---" + cbTrainer.predictRate(uid, movieID));
			System.out.println("!!!" + movieID);
			map.put(movieID, cbTrainer.predictRate(uid, movieID));
			i++;
		}
		sorted_map.putAll(map);
		i = 1;
		System.out.println("length" + sorted_map.size());
		List<Movie> cb_rating_movie = new ArrayList<>();
		for (Long movieid : sorted_map.keySet()) {
			if (i <= 3) {
				i++;
				cb_rating_movie.add(movieService.get(Movie.class, movieid));
				System.out.println("mid" + movieid);
			}
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("flag", flag);
		session.put("mf", mf);
		session.put("movieList", cb_rating_movie);
		session.put("way", way);
		return "cbRating";
	}

}
