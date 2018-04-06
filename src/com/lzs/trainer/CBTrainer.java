package com.lzs.trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzs.model.Movie;
import com.lzs.model.Rating;
import com.lzs.model.User;
import com.lzs.service.MovieService;
import com.lzs.service.RatingService;
import com.lzs.service.UserService;

public class CBTrainer {
	private RatingService ratingService;
	private UserService userService;
	private MovieService movieService;

	private Map<Long, Double[]> currentProfiles = new HashMap<>();

	public CBTrainer(RatingService ratingService, UserService userService, MovieService movieService) {
		this.ratingService = ratingService;
		this.userService = userService;
		this.movieService = movieService;
	}

	public double predictRate(long uid, long mid) {
		double prediction = 0;

		// get the user
		User user = userService.get(User.class, uid);

		// get the movie
		Movie movie = movieService.get(Movie.class, mid);

		// construct the movie profile
		Double[] movieProfile = getMovieProfile(movie);

		Object[] param1 = { uid };
		// retrieve all the ratings the user has rated
		List<Rating> userRatings = ratingService.find("from Rating r where r.user.id = ?", param1);

		// double avgRate = 3;

		// construct the user profile
		Double[] userProfile = currentProfiles.getOrDefault(uid, null);

		if (userProfile == null) {
			if (userRatings.size() > 4) {
				// if user has rated at least five movies
				// retrieve the average of ratings the user has rated
				// avgRate = ratingService.average("select avg(r.rate) from
				// Rating r
				// where r.user.id = ?", param1);
				userProfile = getUserProfile(userRatings);
				currentProfiles.put(uid, userProfile);
			} else {
				// if user has rated less than five movies, we construct the
				// profile
				// based on his or her similar users
				List<User> users = findSimilareUsers(user);
				List<Double[]> userProfiles = new ArrayList<>();
				for (User u : users) {
					Double[] user2Profile = currentProfiles.getOrDefault(u.getId(), null);
					if (user2Profile != null) {
						userProfiles.add(user2Profile);
						continue;
					}
					Object[] param2 = { u.getId() };
					List<Rating> user2Ratings = ratingService.find("from Rating r where r.user.id = ?", param2);
					if (user2Ratings.size() > 4) {
						// double user2AvgRate = ratingService.average("select
						// avg(r.rate) from Rating r where r.user.id = ?",
						// param2);
						user2Profile = getUserProfile(user2Ratings);
						currentProfiles.put(u.getId(), user2Profile);
						userProfiles.add(user2Profile);
					}
				}

				userProfile = new Double[18];
				
				for (int i = 0; i < 18; i++)
					userProfile[i] = 0.0;

				for (int i = 0; i < userProfiles.size(); i++) {
					for (int j = 0; j < 18; j++) {
						userProfile[j] += userProfiles.get(i)[j];
					}
				}
				for (int i = 0; i < 18; i++)
					userProfile[i] /= userProfiles.size();
			}
		}
		// prediction = avgRate;

		for (int i = 0; i < 18; i++) {
			prediction += userProfile[i] * movieProfile[i];
		}

		return prediction;
	}

	private List<User> findSimilareUsers(User user) {

		// retrieve 50 users whose genders are same to this user
		Object[] param = { user.getGender() };
		List<User> users = userService.find("from User u where u.gender = ?", param, 1, 50);

		if (users.size() < 10)
			return users;

		// filter the users based on occupation
		List<User> sameOccuUsers = new ArrayList<>();
		for (User u : users) {
			if (u.getOccupation() == user.getOccupation())
				sameOccuUsers.add(u);
		}
		// if more than 5 users share the same occupation with this user, take
		// this as consideration
		if (sameOccuUsers.size() > 5)
			users = sameOccuUsers;

		if (users.size() < 10)
			return users;

		// filter the users based on age
		List<User> simAgeUsers = new ArrayList<>();
		for (User u : users) {
			if (Math.abs(u.getAge() - user.getAge()) < 5)
				simAgeUsers.add(u);
		}
		// if more than 5 users are about the same age to this user, take this
		// as consideration
		if (simAgeUsers.size() > 5)
			users = simAgeUsers;

		return users;
	}

	private Double[] getMovieProfile(Movie movie) {
		Double[] result = new Double[18];
		for (int i = 0; i < 18; i++)
			result[i] = 0.0;

		int genres = 0;
		if (movie.isAction()) {
			result[0] = 1.0;
			genres++;
		}
		if (movie.isAdventure()) {
			result[1] = 1.0;
			genres++;
		}
		if (movie.isAnimation()) {
			result[2] = 1.0;
			genres++;
		}
		if (movie.isChildren()) {
			result[3] = 1.0;
			genres++;
		}
		if (movie.isComedy()) {
			result[4] = 1.0;
			genres++;
		}
		if (movie.isCrime()) {
			result[5] = 1.0;
			genres++;
		}
		if (movie.isDocumentary()) {
			result[6] = 1.0;
			genres++;
		}
		if (movie.isDrama()) {
			result[7] = 1.0;
			genres++;
		}
		if (movie.isFantasy()) {
			result[8] = 1.0;
			genres++;
		}
		if (movie.isFilmnoir()) {
			result[9] = 1.0;
			genres++;
		}
		if (movie.isHorror()) {
			result[10] = 1.0;
			genres++;
		}
		if (movie.isMusical()) {
			result[11] = 1.0;
			genres++;
		}
		if (movie.isMystery()) {
			result[12] = 1.0;
			genres++;
		}
		if (movie.isRomance()) {
			result[13] = 1.0;
			genres++;
		}
		if (movie.isScifi()) {
			result[14] = 1.0;
			genres++;
		}
		if (movie.isThriller()) {
			result[15] = 1.0;
			genres++;
		}
		if (movie.isWar()) {
			result[16] = 1.0;
			genres++;
		}
		if (movie.isWestern()) {
			result[17] = 1.0;
			genres++;
		}

		if (genres > 0)
			for (int i = 0; i < 18; i++)
				result[i] /= genres;

		return result;
	}

	private Double[] getUserProfile(List<Rating> ratings) {
		Double[] result = new Double[18];
		for (int i = 0; i < 18; i++)
			result[i] = 0.0;

		int[] genres = new int[18];
		for (Rating rating : ratings) {
			if (rating.getMovie().isAction()) {
				result[0] += rating.getRate();
				genres[0]++;
			}
			if (rating.getMovie().isAdventure()) {
				result[1] += rating.getRate();
				genres[1]++;
			}
			if (rating.getMovie().isAnimation()) {
				result[2] += rating.getRate();
				genres[2]++;
			}
			if (rating.getMovie().isChildren()) {
				result[3] += rating.getRate();
				genres[3]++;
			}
			if (rating.getMovie().isComedy()) {
				result[4] += rating.getRate();
				genres[4]++;
			}
			if (rating.getMovie().isCrime()) {
				result[5] += rating.getRate();
				genres[5]++;
			}
			if (rating.getMovie().isDocumentary()) {
				result[6] += rating.getRate();
				genres[6]++;
			}
			if (rating.getMovie().isDrama()) {
				result[7] += rating.getRate();
				genres[7]++;
			}
			if (rating.getMovie().isFantasy()) {
				result[8] += rating.getRate();
				genres[8]++;
			}
			if (rating.getMovie().isFilmnoir()) {
				result[9] += rating.getRate();
				genres[9]++;
			}
			if (rating.getMovie().isHorror()) {
				result[10] += rating.getRate();
				genres[10]++;
			}
			if (rating.getMovie().isMusical()) {
				result[11] += rating.getRate();
				genres[11]++;
			}
			if (rating.getMovie().isMystery()) {
				result[12] += rating.getRate();
				genres[12]++;
			}
			if (rating.getMovie().isRomance()) {
				result[13] += rating.getRate();
				genres[13]++;
			}
			if (rating.getMovie().isScifi()) {
				result[14] += rating.getRate();
				genres[14]++;
			}
			if (rating.getMovie().isThriller()) {
				result[15] += rating.getRate();
				genres[15]++;
			}
			if (rating.getMovie().isWar()) {
				result[16] += rating.getRate();
				genres[16]++;
			}
			if (rating.getMovie().isWestern()) {
				result[17] += rating.getRate();
				genres[17]++;
			}
		} // end for...

		for (int i = 0; i < 18; i++)
			if (genres[i] > 0)
				result[i] /= genres[i];

		return result;
	}

}
