package com.lzs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzs.model.Rating;

public class MathTool {
	/**
	 * Compute the cosine similarity
	 * 
	 * @param ratings1
	 * @param ratings2
	 * @return
	 */
	public static double getSimilarity(List<Rating> ratings1, List<Rating> ratings2) {
		double sim = 0;

		// construct two maps from ratings
		Map<Long, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
		for (Rating rating : ratings1)
			map1.put(rating.getMovie().getId(), rating.getRate());
		for (Rating rating : ratings2)
			map2.put(rating.getMovie().getId(), rating.getRate());

		double innerProduct = 0, distance1 = 0, distance2 = 0;
		for (Long key : map1.keySet()) {
			if (map2.containsKey(key)) {
				innerProduct += map1.get(key) * map2.get(key);
				distance1 += Math.pow(map1.get(key), 2);
				distance2 += Math.pow(map2.get(key), 2);
			}
		}

		if (distance1 != 0 && distance2 != 0)
			sim = innerProduct / (Math.sqrt(distance1) * Math.sqrt(distance2));

		return sim;
	}

	/**
	 * Compute the average rating
	 * 
	 * @param ratings
	 * @return
	 */
	public static double average(List<Rating> ratings) {
		if (ratings.size() == 0)
			return 0;
		double result = 0;
		for (Rating rating : ratings)
			result += rating.getRate();
		return result / ratings.size();
	}
}
