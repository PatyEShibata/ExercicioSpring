package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.CidadeDTO;

public class AgenciaAdapter {

	public static AgenciaDTO transformaEntidadeParaDTO(Agencia agencia) {
		AgenciaDTO dto = new AgenciaDTO();
		CidadeDTO cidadeDto = new CidadeDTO();
		cidadeDto.setNome(agencia.getCidade().getNome());
		dto.setId(agencia.getId());
		dto.setNumeroBanco(agencia.getNumero());
		dto.setCidadeDTO(cidadeDto);
		dto.setNumero(agencia.getNumero());
		
		return dto;
	}
}
