package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.domain.entity.Conta.EstadoConta;
import com.db1start.cidadesapi.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criar(String numeroConta,Double saldo, Agencia agencia, Cliente cliente) {
		Conta conta = new Conta(numeroConta,saldo, cliente, agencia);
		return contaRepository.save(conta);
	}
	
	public Conta buscarPorNumero(String numeroConta) {
		return contaRepository.findByNumero(numeroConta).orElseThrow(() -> new RuntimeException ("conta não encontrada"));
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
	
}