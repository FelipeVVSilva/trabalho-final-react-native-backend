package com.controle.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.entities.Produto;
import com.controle.estoque.repositories.ProdutoRepository;
import com.controle.estoque.services.exceptions.CodigoExistenteException;
import com.controle.estoque.services.exceptions.ProdutoInexistenteException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto> findAllProducts(){
		return repo.findAll();
	}
	
	public Produto findByCodigo(String codigo) {
		Produto produto = repo.findByCodigo(codigo);
		if(produto != null) {
			return produto;
		}
		else {
			throw new ProdutoInexistenteException("O código digitado não existe.");
		}
	}
	
	public Produto findByName(String name) {
		Produto produto = repo.findByName(name);
		if(produto != null) {
			return produto;
		}
		else {
			throw new ProdutoInexistenteException("O nome digitado não existe.");
		}
	}
	
	public Produto insertProduto(Produto produto) {
		validaProduto(produto.getCodigo());
		Produto savedProduto = repo.save(produto);
		return savedProduto;
	}
	
	public Produto updateProduto(Long id, Produto produto) {
		Optional<Produto> p = repo.findById(id);
		Produto novoProduto = p.get();
		
		novoProduto.setName(produto.getName());
		novoProduto.setQuantidade(produto.getQuantidade());
		novoProduto.setMedida(produto.getMedida());
		
		novoProduto = repo.save(novoProduto);
		
		return novoProduto;
	}
	
	public void deleteProduto(Long id) {
			repo.deleteById(id);
	}
	
	private void validaProduto(String codigo) {
		Produto prodValidacao = repo.findByCodigo(codigo);
		if(prodValidacao != null) {
			throw new CodigoExistenteException("O código informado já existe!");
		}
	}
}
