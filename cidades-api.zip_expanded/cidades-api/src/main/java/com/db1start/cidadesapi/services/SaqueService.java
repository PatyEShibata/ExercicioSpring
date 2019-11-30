package com.db1start.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Conta;

@Service
public class SaqueService {
	
	@Autowired
	public ContaService contaService;
	
	public Conta sacar(String numeroConta, Double valorSaque) {
		Conta conta = contaService.buscarPorNumero(numeroConta);
		Double saldo = conta.getSaldo();
		if (saldo < valorSaque) {
			throw new RuntimeException ("Valor inválido.");
		}
		conta.setSaldo(saldo - valorSaque);
		return contaService.salvar(conta);
		
	}

}
