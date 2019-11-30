package com.db1start.cidadesapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "saldo", length=10, precision = 2)
	private Double saldo;
	
	@Column (name = "numero")
	private String numero;
	
	@OneToOne
	@JoinColumn (name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn (name = "agencia_id")
	private Agencia agencia;
		
	public enum EstadoConta {
	    ATIVA,
	    INATIVA;
	}

	public Conta() {
		
	}
	
	public Conta(String numeroConta, Double saldo, Cliente cliente, Agencia agencia) {
		this.numero = numeroConta;
		this.saldo = saldo;
		this.cliente = cliente;
		this.agencia = agencia;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
