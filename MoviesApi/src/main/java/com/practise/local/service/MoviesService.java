package com.practise.local.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.local.model.Movies;
import com.practise.local.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;
	public List<Movies> allMovies()
	{
//		System.out.println(moviesRepository.findAll().toString());
		return moviesRepository.findAll();
	}
	public Optional<Movies> singleMovie(String imdbId)
	{
		return moviesRepository.findByimdbId(imdbId);
	}
}
