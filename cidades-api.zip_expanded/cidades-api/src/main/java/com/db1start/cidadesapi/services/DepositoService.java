package com.db1start.cidadesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Conta;

@Service
public class DepositoService {
	
	@Autowired
	public ContaService contaService;
	
	public Conta depositar(String numero, Double valorDeposito) {
		Conta conta = contaService.buscarPorNumero(numero);
		Double saldo = conta.getSaldo();
		if (valorDeposito < 0) {
			throw new RuntimeException ("Valor inválido.");
		}
		conta.setSaldo(saldo + valorDeposito);
		return contaService.salvar(conta);
	}

}
