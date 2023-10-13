package com.controle.estoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.entities.Cliente;
import com.controle.estoque.repositories.ClienteRepository;
import com.controle.estoque.services.exceptions.ClienteExistenteException;
import com.controle.estoque.services.exceptions.ClienteInexistenteException;
import com.controle.estoque.services.exceptions.LoginIncorretoException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public String login(Cliente cliente) {
		Cliente c = repo.findByEmail(cliente.getEmail());
		
		if(c != null) {
			if(c.getEmail().equals(cliente.getEmail()) && c.getSenha().equals(cliente.getSenha())) {
				return "Autorizado";
			}
			else {
				throw new LoginIncorretoException("Email ou senha incorretos. Tente novamente");
			}
		}
		else {
			throw new ClienteInexistenteException("O e-mail digitado não existe. Por favor digitar um e-mail válido");
		}
	}
	
	public Cliente insertCliente(Cliente cliente) {
		Cliente c = repo.findByEmail(cliente.getEmail());
		if(c == null) {
			cliente = repo.save(cliente);
			return cliente;
		}
		else {
			throw new ClienteExistenteException("O e-mail digitado já está cadastrado. Por favor tente com outro e-mail.");
		}
		
	}
	
}
