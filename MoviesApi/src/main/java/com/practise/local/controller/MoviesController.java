package com.practise.local.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.local.model.Movies;
import com.practise.local.service.MoviesService;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	@GetMapping
	public ResponseEntity<List<Movies>> getallMovies() {
		return new ResponseEntity<List<Movies>>(moviesService.allMovies(), HttpStatus.OK);
	}

	@GetMapping("{imdbId}")
	public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable String imdbId) {

		return new ResponseEntity<Optional<Movies>>(moviesService.singleMovie(imdbId), HttpStatus.OK);

	}
}
