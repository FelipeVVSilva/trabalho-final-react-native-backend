package com.controle.estoque.services.exceptions;

public class ProdutoInexistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ProdutoInexistenteException(String msg) {
		super(msg);
	}
	
}
