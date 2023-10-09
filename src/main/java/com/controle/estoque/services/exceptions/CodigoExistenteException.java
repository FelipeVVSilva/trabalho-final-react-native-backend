package com.controle.estoque.services.exceptions;

public class CodigoExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CodigoExistenteException(String msg) {
		super(msg);
	}
	
}
