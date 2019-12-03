package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.dto.ContaDTO;

public class ContaAdapter {

	public static ContaDTO transformaEntidadeParaDTO(Conta conta) {
		ContaDTO dto = new ContaDTO();
		dto.setId(conta.getId());
		dto.setNumero(conta.getNumero());
		dto.setCliente(conta.getCliente());
		dto.setSaldo(conta.getSaldo());
		dto.setAgencia(conta.getAgencia());
		return dto;
	}
}
