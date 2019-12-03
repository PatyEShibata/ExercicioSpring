package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Cidade;

public class AgenciaFormDTO {
	
	private Long cidadeId;

	private String numero;
	
	private String numeroBanco;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
}
