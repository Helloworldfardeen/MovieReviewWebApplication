package com.practise.local.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.local.model.Review;
import com.practise.local.service.ReviewService;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
	@Autowired
	private ReviewService reveiwService;

	@PostMapping
	public ResponseEntity<Review> postReview(@RequestBody Map<String, String> payload )
	{
		return new ResponseEntity<Review>(reveiwService.addReviewToMovie(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);
	}

}
