package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.dto.AgenciaDTO;

public class AgenciaAdapter {

	public static AgenciaDTO transformaEntidadeParaDTO(Agencia agencia) {
		AgenciaDTO dto = new AgenciaDTO();
		dto.setId(agencia.getId());
		dto.setNumeroBanco(agencia.getNumero());
		dto.setCidade(agencia.getCidade());
		dto.setNumero(agencia.getNumero());
		
		return dto;
	}
}
