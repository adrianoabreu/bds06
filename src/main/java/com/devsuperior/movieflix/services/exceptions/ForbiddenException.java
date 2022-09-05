package com.devsuperior.movieflix.services.exceptions;

// Essa classe representa a exceção codigo 403, ou seja, quando o usuário está logado o token dele é válido, mas o perfil dele não pode acessar algum recurso de acordo com o negócio.
public class ForbiddenException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}
}
