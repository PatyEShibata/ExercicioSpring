package com.db1start.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	public AgenciaRepository agenciaRepository;
	
	public Agencia criar(String numero) {
		Agencia agencia = new Agencia ();
		return agenciaRepository.save(agencia);
	}

	public Agencia buscarPorNumero(String numero) {
		return agenciaRepository.findByNome(numero).orElseThrow(() -> new RuntimeException("estado não encontrado"));
	}
}
