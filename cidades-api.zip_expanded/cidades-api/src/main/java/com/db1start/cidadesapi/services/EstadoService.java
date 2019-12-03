package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.EstadoFormDTO;
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
	
	public Estado buscarPorId(Long id) {
		return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("estado não encontrado"));
	}
	
	public void deletar(String nome) {
		Estado estado = buscarPorNome(nome); 
		 estadoRepository.delete(estado);
	}
	
	public void deletarPorId(Long id) {
		estadoRepository.deleteById(id);
	}
	
	public List<Estado> buscarTodosEstados() {
		return estadoRepository.findAll();
	}
	
	public void limpar() {
		estadoRepository.deleteAll();
		
	}
	
	public Estado atualizar(Long estadoId, String novoNome) {
        Estado estado = buscarPorId(estadoId);
        estado.setNome(novoNome);
        return estadoRepository.save(estado);
    }

	
	public Estado atualizar (Long estadoId, EstadoFormDTO alteracoes) {
		Estado estado = buscarPorId(estadoId);
		estado.setNome(alteracoes.getNome());
		return estadoRepository.save(estado);
	}
}
