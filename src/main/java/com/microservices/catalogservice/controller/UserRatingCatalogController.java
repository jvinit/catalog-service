package com.microservices.catalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.catalogservice.model.CatalogItem;
import com.microservices.catalogservice.model.Movie;
import com.microservices.catalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class UserRatingCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		UserRatings userRatings = restTemplate.getForObject("http://rating-service/ratings/api/users/" + userId, UserRatings.class);

		return userRatings.getRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-data-service/movieApi/movie/"+ rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), movie.getMovieDesc(), rating.getRating());
		})
		.collect(Collectors.toList());
		
		/*return new ArrayList<>(Arrays.asList(
					new CatalogItem("Test", "TestDesc", 3.0),
					new CatalogItem("Test1", "TestDesc1", 4.0)
				));*/
	}
	
}
