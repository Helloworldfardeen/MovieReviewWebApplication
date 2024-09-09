package com.practise.local.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practise.local.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
