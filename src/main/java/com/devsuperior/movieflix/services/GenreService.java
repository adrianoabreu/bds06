package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.GenreService;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

//public class GenreService implements UserDetailsService{
@Service
public class GenreService {

	private static Logger logger = LoggerFactory.getLogger(GenreService.class);
	
	@Autowired
	private GenreRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public List<GenreDTO> findAll(){
		List<Genre> list = repository.findAll(Sort.by("id"));
		return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
}
