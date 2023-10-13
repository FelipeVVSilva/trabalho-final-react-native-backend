package com.controle.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.estoque.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByEmail(String email);
	
}
