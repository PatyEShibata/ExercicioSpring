package com.db1start.cidadesapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	public AgenciaRepository agenciaRepository;
	
	public Agencia criar(String numero,String numeroBanco, Cidade nome) {
		Agencia agencia = new Agencia (numero, numeroBanco,nome);
		return agenciaRepository.save(agencia);
	}

	public Agencia buscarPorNumero(String numero) {
		return agenciaRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("agência não encontrado"));
	}
		
	public void deletar(String numero) {
		Agencia agencia = buscarPorNumero(numero);
		agenciaRepository.delete(agencia);
	}

	public List <Agencia> buscarTodasAgenciasDeUmaCidade(String nomeCidade) {
		return agenciaRepository.findByCidadeNome(nomeCidade);
	}
	
	public void limpar() {
		agenciaRepository.deleteAll();
		
	}
	
	public List<Agencia> buscarTodasAgencias() {
		return agenciaRepository.findAll();
		
	}
	
}
