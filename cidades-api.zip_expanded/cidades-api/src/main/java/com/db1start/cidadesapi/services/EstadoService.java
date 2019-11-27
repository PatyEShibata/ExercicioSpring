package com.db1start.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public Estado buscarPorNome(String nome) {
		return estadoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("estado não encontrado"));
	}
	
	public void deletar(Long id) {
		 estadoRepository.deleteById(id);
	}
}
