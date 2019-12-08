package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Estado;

public class CidadeFormDTO {

	private String nome;

	private Long estadoId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	
	
}
