package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieIdDTO;
import com.devsuperior.movieflix.dto.MoviePageDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true) 
	public Page<MoviePageDTO> findByGenre(Long genreId, Pageable pageable){
		Page<Movie> page = repository.findByGenre(genreId, pageable);      
		return page.map(x -> new MoviePageDTO(x));
	}
	
	@Transactional(readOnly = true)
	public MovieIdDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
		
		return new MovieIdDTO(movie, movie.getGenre());
	}
	
	@Transactional(readOnly = true)
	public MovieReviewDTO reviewFindById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
		
		return new MovieReviewDTO(movie);
	}
}
