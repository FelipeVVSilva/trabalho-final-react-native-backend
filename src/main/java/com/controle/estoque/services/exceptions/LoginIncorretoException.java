package com.controle.estoque.services.exceptions;

public class LoginIncorretoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LoginIncorretoException(String msg) {
		super(msg);
	}
	
}
