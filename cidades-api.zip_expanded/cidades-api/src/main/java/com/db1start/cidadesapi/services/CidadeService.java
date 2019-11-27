package com.db1start.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade criar(String nome) {
		Cidade cidade = new Cidade();
		return cidadeRepository.save(cidade);
	}
	
	public Cidade buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("cidade não encontrada"));
	}

}
