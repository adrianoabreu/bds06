package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.User;

public class GenreDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long   id;
	private String name;
	
	List<MovieDTO> movies = new ArrayList<>();

	public GenreDTO() {
		
	}

	public GenreDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public GenreDTO(Genre entity) {
		id       = entity.getId();
		name     = entity.getName();
	}
	
	public GenreDTO(Genre entity, List<Movie> movies) {
		this(entity);
		movies.forEach(mov -> this.movies.add(new MovieDTO(mov)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}	
	
	

}
