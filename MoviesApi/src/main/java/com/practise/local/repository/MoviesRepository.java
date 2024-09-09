package com.practise.local.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practise.local.model.Movies;

@Repository
public interface MoviesRepository extends MongoRepository<Movies, ObjectId> {

	Optional<Movies> findByimdbId(String imdbId);
}
