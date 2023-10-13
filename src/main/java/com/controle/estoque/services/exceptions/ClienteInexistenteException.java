package com.controle.estoque.services.exceptions;

public class ClienteInexistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClienteInexistenteException(String msg) {
		super(msg);
	}
	
}
