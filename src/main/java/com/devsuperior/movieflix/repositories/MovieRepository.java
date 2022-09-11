package com.devsuperior.movieflix.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	
	@Query("SELECT obj FROM Movie obj WHERE "
	        + "(obj.id = :id) ")
	Movie find(Long id);
	
	//Resolvendo problema das N+1 consultas
	@Query("SELECT obj, obj.user.name FROM Review obj INNER JOIN obj.user JOIN FETCH obj.movie WHERE obj.movie = :movie")
	List<Review> findMoviesWithReviews(Movie movie);
}
