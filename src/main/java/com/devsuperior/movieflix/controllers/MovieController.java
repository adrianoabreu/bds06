package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieIdDTO;
import com.devsuperior.movieflix.dto.MoviePageDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MoviePageDTO>> findByGenre(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId, 
			Pageable pageable){
		Page<MoviePageDTO> page = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieIdDTO> findById(@PathVariable Long id){
		MovieIdDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<MovieReviewDTO> reviewsFindById(@PathVariable Long id){
		MovieReviewDTO dto = service.reviewFindById(id);
		return ResponseEntity.ok().body(dto);
	}
}
