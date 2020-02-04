package com.microservices.catalogservice.model;

public class Rating {
	
	private String movieId;
	private Double rating;
	
	public Rating() {
		
	}
	
	public Rating(String movieId, Double rating) {
		this.movieId = movieId;
		this.rating = rating;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}	
}
