package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.Role;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Review entity = new Review();
		copyToDto(entity, dto);
		entity = repository.save(entity);
		return new ReviewDTO(entity, entity.getUser());
	}

	private void copyToDto(Review entity, ReviewDTO dto) {
		User user = userRepository.findByEmail(userService.loggedUser().getEmail());
		entity.setUser(user);
		isVisitor(user);
		
		entity.setText(dto.getText());
		
		Optional<Movie> movie = movieRepository.findById(dto.getMovieId());
		Movie movieEntity = movie.orElseThrow(() -> new ResourceNotFoundException("Movie Id not found " + dto.getMovieId()));
		entity.setMovie(movieEntity);
	}
	
	private void isVisitor(User user) {
		for(Role visit: user.getRoles()) {
			if(visit.getId() == 1) {
				throw new ForbiddenException("Acesso negado");
			}
		}
	}
}
