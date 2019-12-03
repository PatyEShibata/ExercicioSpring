package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.dto.ClienteDTO;

public class ClienteAdapter {
	
	public static ClienteDTO transformaEntidadeParaDTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setTelefone(cliente.getTelefone());
		return dto;
	}

	
}
