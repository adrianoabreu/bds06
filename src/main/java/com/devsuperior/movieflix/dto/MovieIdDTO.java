package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieIdDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String subTitle;
	
	@NotEmpty
	private String synopsis;
	
	@NotEmpty
	private Integer year;
	
	@NotEmpty
	private String imgUrl;
	
	@NotEmpty
	private GenreDTO genre;
	
	public MovieIdDTO() {
	}

	public MovieIdDTO(Long id, String title, String subTitle, String synopsis, Integer year, String imgUrl, GenreDTO genre) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.synopsis = synopsis;
		this.year = year;
		this.imgUrl = imgUrl;
	}
	
	public MovieIdDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		synopsis = entity.getSynopsis();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
	}
	
	public MovieIdDTO(Movie entity, Genre genre) {
		this(entity);
		this.genre = new GenreDTO(genre);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenreDTO(GenreDTO genre) {
		this.genre = genre;
	}
}
