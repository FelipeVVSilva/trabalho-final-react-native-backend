package com.controle.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.entities.Produto;
import com.controle.estoque.repositories.ProdutoRepository;
import com.controle.estoque.services.exceptions.CodigoExistenteException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto> findAllProducts(){
		return repo.findAll();
	}
	
	public Produto findByCodigo(String codigo) {
		Produto produto = repo.findByCodigo(codigo);
	}
	
	public Produto insertProduto(Produto produto) {
		validaProduto(produto.getCodigo());
		Produto savedProduto = repo.save(produto);
		return savedProduto;
	}
	
	private void validaProduto(String codigo) {
		Produto prodValidacao = repo.findByCodigo(codigo);
		if(prodValidacao != null) {
			throw new CodigoExistenteException("O código informado já existe!");
		}
	}
}
