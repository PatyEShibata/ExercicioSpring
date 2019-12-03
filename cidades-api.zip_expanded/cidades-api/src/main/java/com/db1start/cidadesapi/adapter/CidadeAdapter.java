package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.CidadeDTO;

public class CidadeAdapter {

	public static CidadeDTO transformaEntidadeParaDTO(Cidade cidade) {
		CidadeDTO dto = new CidadeDTO();
		dto.setId(cidade.getId());
		dto.setNome(cidade.getNome());
		dto.setUf(cidade.getUf());
		
		return dto;
	}
}
