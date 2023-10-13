package com.controle.estoque.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.controle.estoque.entities.Produto;
import com.controle.estoque.services.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProducts(){
		List<Produto> produtos = service.findAllProducts();
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<Produto> findByCodigo(@PathVariable String codigo){
		Produto produto = service.findByCodigo(codigo);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping("/nome/{name}")
	public ResponseEntity<List<Produto>> findByName(@PathVariable String name){
		List<Produto> produtos = service.findByName(name);
		return ResponseEntity.ok().body(produtos);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insertProduto(@RequestBody Produto produto){
		produto = service.insertProduto(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto){
		produto = service.updateProduto(id, produto);
		return ResponseEntity.ok().body(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
		service.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
}
