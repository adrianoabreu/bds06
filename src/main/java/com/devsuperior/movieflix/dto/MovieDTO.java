package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class MovieDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long   id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	private GenreDTO genreDTO;
	
	public MovieDTO() {
		
	}

	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id       = id;
		this.title    = title;
		this.subTitle = subTitle;
		this.year     = year;
		this.imgUrl   = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieDTO(Movie entity) {
		this.id       = entity.getId();
		this.title    = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.year     = entity.getYear();
		this.imgUrl   = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
//		this.genre    = entity.getGenre();
	}
	
	public MovieDTO(Movie entity, List<Review> reviews) {
		this(entity);
		reviews.forEach(rev -> this.reviews.add(new ReviewDTO(rev)));
	}
	
	public MovieDTO(Movie entity, Genre genre) {
		this.id       = entity.getId();
		this.title    = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.year     = entity.getYear();
		this.imgUrl   = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
		this.genreDTO = new GenreDTO(genre);
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	public GenreDTO getGenreDTO() {
		return genreDTO;
	}

	public void setGenreDTO(GenreDTO genre) {
		this.genreDTO = genre;
	}

}
