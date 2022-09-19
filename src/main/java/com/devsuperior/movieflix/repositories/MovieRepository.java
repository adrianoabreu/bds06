package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT obj FROM Movie obj WHERE (obj.genre.id IN :genreId "
			+ "OR :genreId NOT IN (SELECT obj.genre.id FROM Movie obj)) "
			+ "ORDER BY obj.title ASC")
	Page<Movie> findByGenre(Long genreId, Pageable pageable);
}
