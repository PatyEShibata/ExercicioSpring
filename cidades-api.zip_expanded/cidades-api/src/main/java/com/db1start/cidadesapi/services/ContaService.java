package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.adapter.AgenciaAdapter;
import com.db1start.cidadesapi.adapter.ContaAdapter;
import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.domain.entity.Conta.EstadoConta;
import com.db1start.cidadesapi.dto.ContaFormDTO;
import com.db1start.cidadesapi.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	public Conta criar(String numeroConta,Double saldo, Agencia agencia, Cliente cliente) {
		Conta conta = new Conta(numeroConta,saldo, cliente, agencia);
		return contaRepository.save(conta);
	}
	
	public Conta criar(ContaFormDTO dto) {
		Cliente cliente = clienteService.buscarPorId(dto.getClienteId());
		Agencia agencia = agenciaService.buscarPorId(dto.getAgenciaId());
		return criar(dto.getNumero(), dto.getSaldo(), agencia, cliente);
	}
	public Conta buscarPorNumero(String numeroConta) {
		return contaRepository.findByNumero(numeroConta).orElseThrow(() -> new RuntimeException ("conta não encontrada"));
	}
	
	public Conta buscarPorId(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new RuntimeException ("conta não encontrada"));
	}
	
	public EstadoConta buscarContasAtivas() {
		EstadoConta estadoConta = EstadoConta.ATIVA;
		return estadoConta.ATIVA;
	}
	
	public EstadoConta buscarContasInativas() {
		EstadoConta estadoConta = EstadoConta.INATIVA;
		return estadoConta.INATIVA;
	}
	
	public void deletar(String numeroConta) {
		Conta conta = buscarPorNumero(numeroConta);
		contaRepository.delete(conta);
	}
	
	public void deletarPorId(Long contaId) {
		Conta conta = buscarPorId(contaId);
		contaRepository.delete(conta);
	}

	public Conta salvar(Conta conta) {
		return contaRepository.save(conta);
	}	
	
	public void limpar() {
		contaRepository.deleteAll();
	}
	
	public List<Conta> buscarTodasContas(){
		return contaRepository.findAll();
	}
	
	public List<Conta> buscarTodasContasNaAgencia(String numero) {
		return contaRepository.findByAgenciaNumero(numero);
	}
	
	public Conta atualizar(Long contaId, ContaFormDTO alteracoes) {
		Conta conta = buscarPorId(contaId);
		conta.setNumero(alteracoes.getNumero());
		conta.setAgencia(agenciaService.buscarPorId(alteracoes.getAgenciaId()));
		conta.setCliente(clienteService.buscarPorId(alteracoes.getClienteId()));
		conta.setSaldo(alteracoes.getSaldo());
		return contaRepository.save(conta);
	}
	
}