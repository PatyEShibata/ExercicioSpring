package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Cidade;

public class AgenciaDTO {

	private Long id;
	
	private String numero;
	
	private Cidade cidade;

	private String numeroBanco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	
}
