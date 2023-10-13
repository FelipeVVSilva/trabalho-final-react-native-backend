package com.controle.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.estoque.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByCodigo(String codigo);
	
	List<Produto> findByName(String name);
	
}
