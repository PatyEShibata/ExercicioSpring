package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.EstadoDTO;

public class EstadoAdapter {
	
	public static EstadoDTO transformaEntidadeParaDTO(Estado estado) {
		EstadoDTO dto = new EstadoDTO();
		dto.setId(estado.getId());
		dto.setNome(estado.getNome());
		return dto;
	}

}
