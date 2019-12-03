package com.db1start.cidadesapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn (name = "estado_id")
	private Estado uf;
	
	@OneToMany (mappedBy = "cidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	List<Agencia> agencias = new ArrayList<>();

	public Cidade () {
	}

	public Cidade (String nome, Estado uf) {
		this.nome = nome;
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}
	
	public Estado getUf() {
		return uf;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	
	
}
