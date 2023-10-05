package com.controle.estoque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long codigo;
	private String name;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "medida_id")
	private TipoMedida medida;
	
	public Produto() {
		super();
		
	}
	public Produto(Long id, Long codigo, String name, Integer quantidade, TipoMedida medida) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.name = name;
		this.quantidade = quantidade;
		this.medida = medida;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public TipoMedida getMedida() {
		return medida;
	}
	public void setMedida(TipoMedida medida) {
		this.medida = medida;
	}
}
