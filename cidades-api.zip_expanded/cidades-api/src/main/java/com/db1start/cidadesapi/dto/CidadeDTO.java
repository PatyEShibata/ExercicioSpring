package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Estado;

public class CidadeDTO {
	
	private Long id;
	
	private String nome;
	
	private EstadoDTO estado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstadoDTO(EstadoDTO estado) {
		this.estado = estado;
	}


	
}
