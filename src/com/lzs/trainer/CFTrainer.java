package com.lzs.trainer;

import java.util.List;
import com.lzs.model.Rating;
import com.lzs.service.RatingService;
import com.lzs.util.MathTool;

public class CFTrainer {

	private RatingService ratingService;

	public CFTrainer(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	public double predictRate(long uid, long mid) {
		double prediction = 0;

		// retrieve all the existed ratings which this user has rated
		Object[] params1 = { uid };
		List<Rating> selfRatings = ratingService.find("from Rating r where r.user.id = ?", params1);

		// assign the prediction to the average of ratings by this user
		prediction = MathTool.average(selfRatings);

		// retrieve ten users which have rated this movie
		Object[] params2 = { mid };
		long count = ratingService.count("select count(*) from Rating r where r.movie.id = ?", params2);
		if (count == 0)
			return prediction;
		List<Rating> otherRatings;
		if (count < 10)
			otherRatings = ratingService.find("from Rating r where r.movie.id = ?", params2);
		else
			otherRatings = ratingService.find("from Rating r where r.movie.id = ?", params2, 1, 10);

		double sumDiffs = 0, sumSims = 0;
		for (Rating rating : otherRatings) {
			Object[] params3 = { rating.getUser().getId() };
			List<Rating> thisRatings = ratingService.find("from Rating r where r.user.id = ?", params3);
			double thisAvg = MathTool.average(thisRatings);
			double sim = MathTool.getSimilarity(selfRatings, thisRatings);
			sumDiffs += sim * (rating.getRate() - thisAvg);
			sumSims += sim;
		}

		if (sumSims != 0)
			prediction += sumDiffs / sumSims;

		return prediction;
	}
}
