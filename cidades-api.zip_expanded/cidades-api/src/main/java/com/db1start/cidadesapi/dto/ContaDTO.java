package com.db1start.cidadesapi.dto;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cliente;

public class ContaDTO {

	private Long id;

	private Double saldo;

	private String numero;

	private ClienteDTO cliente;

	private AgenciaDTO agencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public AgenciaDTO getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaDTO agencia) {
		this.agencia = agencia;
	}


}
