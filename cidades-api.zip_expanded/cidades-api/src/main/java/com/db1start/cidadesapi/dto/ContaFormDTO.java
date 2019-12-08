package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cliente;

public class ContaFormDTO {

	private Double saldo;

	private String numero;

	private Long clienteId;

	private Long agenciaId;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getAgenciaId() {
		return agenciaId;
	}

	public void setAgenciaId(Long agenciaId) {
		this.agenciaId = agenciaId;
	}


	
}
