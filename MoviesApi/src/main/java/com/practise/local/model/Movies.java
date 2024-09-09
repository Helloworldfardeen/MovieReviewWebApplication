package com.practise.local.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movies {
	@Id
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseDate;
	private String traillerLink;
	private String poster;
	private List<String> genres;
	private List<String> backdrops;
	@DocumentReference
	private List<Review> reviewIds;
}
