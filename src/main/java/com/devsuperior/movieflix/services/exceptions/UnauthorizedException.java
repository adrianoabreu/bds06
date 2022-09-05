package com.devsuperior.movieflix.services.exceptions;

// Essa classe representa a exceção codigo 401, ou seja, quando o token do usuário é inválido.
public class UnauthorizedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String msg) {
		super(msg);
	}
}
