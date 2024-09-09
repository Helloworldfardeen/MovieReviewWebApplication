package com.practise.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.practise.local.model.Movies;
import com.practise.local.model.Review;
import com.practise.local.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	public Review addReviewToMovie(String reviewBody, String imdbId) {
		// Create a new review and save it to the reviews collection
		Review newReview = reviewRepository.insert(new Review(reviewBody));

		// Create query criteria to find the movie by its IMDb ID
		Criteria criteria = Criteria.where("imdbId").is(imdbId);

		// Create an update operation to push the new review ID to the reviewIds array
		Update update = new Update().push("reviewIds", newReview.getId());

		// Use MongoTemplate to find the first matching movie and apply the update
		mongoTemplate.updateFirst(Query.query(criteria), update, Movies.class);

		return newReview;
	}

//	public Review createReview(String reviewBody, String imdbId)
//	{
//		Review review = reviewRepository.insert(new Review(reviewBody));
//		//you Main logic Start Here SO Understand CareFully;
//		mongoTemplate.update(Movies.class)
//				.matching(Criteria.where("imdbId").is(imdbId))
//				.apply(new Update().push("reviewIds").value(review))
//				.first();
//		
//		
//		return review;
//	}
}
