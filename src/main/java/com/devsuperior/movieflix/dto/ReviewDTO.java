package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long   id;
	@NotBlank(message = "Campo requerido")
	private String text;
	
	private MovieDTO movieDTO;
	
	private UserDTO userDTO;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text) {
		super();
		this.id   = id;
		this.text = text;
	}
	

	public ReviewDTO(Review entity) {
		this.id   = entity.getId();
		this.text = entity.getText();
	}
	
	public ReviewDTO(Review entity, UserDTO userDTO, MovieDTO movieDTO) {
		this.id   = entity.getId();
		this.text = entity.getText();
		this.movieDTO = movieDTO;
		this.userDTO  = userDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public MovieDTO getMovieDTO() {
		return movieDTO;
	}

	public void setMovieDTO(MovieDTO movieDTO) {
		this.movieDTO = movieDTO;
	}
	
	

}
