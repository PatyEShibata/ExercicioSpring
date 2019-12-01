package com.db1start.cidadesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	

	public Cidade criar(String nome, Estado estado) {
		Cidade cidade = new Cidade(nome, estado);
		return cidadeRepository.save(cidade);
	}

	public Cidade buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("cidade não encontrada"));
	}

	public void deletar(String nome) {
		Cidade cidade = buscarPorNome(nome);
		cidadeRepository.delete(cidade);
	}

	public void limpar() {
		cidadeRepository.deleteAll();
		
	}
	
	public List<Cidade> buscarTodasCidadesDeUmEstado(String nomeEstado){
		return cidadeRepository.findByUfNome(nomeEstado);
	}
	
	public List <Cidade> buscarTodasCidades(){
		return cidadeRepository.findAll();
	}
	
}
