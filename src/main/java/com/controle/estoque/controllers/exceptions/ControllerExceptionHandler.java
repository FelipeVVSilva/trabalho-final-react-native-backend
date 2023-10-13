package com.controle.estoque.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.controle.estoque.services.exceptions.ClienteExistenteException;
import com.controle.estoque.services.exceptions.ClienteInexistenteException;
import com.controle.estoque.services.exceptions.CodigoExistenteException;
import com.controle.estoque.services.exceptions.LoginIncorretoException;
import com.controle.estoque.services.exceptions.ProdutoInexistenteException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CodigoExistenteException.class)
	public ResponseEntity<StandardError> codigoExistente(CodigoExistenteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), "Código Existente!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ProdutoInexistenteException.class)
	public ResponseEntity<StandardError> produtoInexistente(ProdutoInexistenteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "Produto não encontrado!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(LoginIncorretoException.class)
	public ResponseEntity<StandardError> loginIncorreto(LoginIncorretoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		StandardError err = new StandardError(Instant.now(), status.value(), "Login incorreto!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<StandardError> clienteExistente(ClienteExistenteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), "E-mail digitado já cadastrado!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ClienteInexistenteException.class)
	public ResponseEntity<StandardError> clienteExistente(ClienteInexistenteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), "E-mail digitado não existe!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
