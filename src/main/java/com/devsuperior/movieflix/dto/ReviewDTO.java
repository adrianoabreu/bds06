package com.devsuperior.movieflix.dto;

import java.io.Serializable;

public class ReviewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long   movieId;
	private String text;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long movieId, String text) {
		super();
		this.movieId = movieId;
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
