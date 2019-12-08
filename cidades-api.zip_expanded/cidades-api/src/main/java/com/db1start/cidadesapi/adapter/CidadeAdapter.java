package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.CidadeDTO;
import com.db1start.cidadesapi.dto.EstadoDTO;

public class CidadeAdapter {

	public static CidadeDTO transformaEntidadeParaDTO(Cidade cidade) {
		CidadeDTO dto = new CidadeDTO();
		EstadoDTO estadoDto = new EstadoDTO();
		estadoDto.setNome(cidade.getUf().getNome());
		estadoDto.setId(cidade.getUf().getId());
		dto.setId(cidade.getId());
		dto.setNome(cidade.getNome());
		dto.setEstadoDTO(estadoDto);
		
		return dto;
	}
}
