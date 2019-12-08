package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.AgenciaFormDTO;
import com.db1start.cidadesapi.repository.AgenciaRepository;
import com.db1start.cidadesapi.repository.CidadeRepository;

@Service
public class AgenciaService {

	@Autowired
	public AgenciaRepository agenciaRepository;
	
	@Autowired
	public CidadeService cidadeService;
	
	public Agencia criar(AgenciaFormDTO dto) {
		Cidade cidade = cidadeService.buscarPorId(dto.getCidadeId());
		return criar(dto.getNumero(), dto.getNumeroBanco(), cidade);
	}
	
	public Agencia criar(String numero,String numeroBanco, Cidade nome) {
		Agencia agencia = new Agencia (numero, numeroBanco,nome);
		return agenciaRepository.save(agencia);
	}

	public Agencia buscarPorNumero(String numero) {
		return agenciaRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("agência não encontrado"));
	}
	
	public Agencia buscarPorId(Long id) {
		return agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("agência não encontrado"));
	}
		
	public void deletar(String numero) {
		Agencia agencia = buscarPorNumero(numero);
		agenciaRepository.delete(agencia);
	}
	
	public void deletarPorId(Long id) {
		Agencia agencia = buscarPorId(id);
		agenciaRepository.deleteById(id);
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

	public Agencia atualizar(Long agenciaId, AgenciaFormDTO alteracoes) {
		Agencia agencia = buscarPorId(agenciaId);
		agencia.setNumero(alteracoes.getNumero());
		agencia.setNumeroBanco(alteracoes.getNumeroBanco());
		agencia.setCidade(cidadeService.buscarPorId(alteracoes.getCidadeId()));
		return agenciaRepository.save(agencia);
		
	}
	
}
