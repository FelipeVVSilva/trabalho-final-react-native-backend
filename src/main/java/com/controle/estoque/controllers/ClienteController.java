package com.controle.estoque.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.controle.estoque.entities.Cliente;
import com.controle.estoque.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Cliente cliente){
		String res = service.login(cliente);
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
		cliente = service.insertCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
}
