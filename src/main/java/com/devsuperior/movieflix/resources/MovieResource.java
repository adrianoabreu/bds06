package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){	
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
/*
	@GetMapping(value = "/{movieId}/reviews")
	public ResponseEntity<List<MovieDTO>> findByIdReviews(@PathVariable Long movieId){	
		List<MovieDTO> dto = service.findByIdReviews(movieId);
		return ResponseEntity.ok().body(dto);
	}
*/	
	
	@GetMapping(value = "/{movieId}/reviews")
	public ResponseEntity<MovieDTO> findByIdReviews(@PathVariable Long movieId){	
		MovieDTO dto = service.findByIdReviews(movieId);
		return ResponseEntity.ok().body(dto);
	}

}