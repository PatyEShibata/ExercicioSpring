package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Estado;

public class CidadeFormDTO {

	private String nome;

	private Estado uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}
	
	
}
