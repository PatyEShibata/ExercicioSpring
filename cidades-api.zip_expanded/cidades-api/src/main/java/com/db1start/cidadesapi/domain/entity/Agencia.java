package com.db1start.cidadesapi.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "número")
	private String numero;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@Column (name = "numero_banco")
	private String numeroBanco;

	
	public Agencia() {
		
	}

	public Agencia(String numero, String numeroBanco, Cidade cidade) {
		this.numero = numero;
		this.numeroBanco = numeroBanco;
		this.cidade = cidade;
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
