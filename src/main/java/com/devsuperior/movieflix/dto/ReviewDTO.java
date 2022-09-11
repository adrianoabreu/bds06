package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long   id;
	@NotBlank(message = "Campo requerido")
	private String text;
	
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
