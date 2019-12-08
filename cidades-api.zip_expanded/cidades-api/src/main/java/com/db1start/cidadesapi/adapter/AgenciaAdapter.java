package com.db1start.cidadesapi.adapter;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.CidadeDTO;
import com.db1start.cidadesapi.dto.EstadoDTO;

public class AgenciaAdapter {

	public static AgenciaDTO transformaEntidadeParaDTO(Agencia agencia) {
		AgenciaDTO dto = new AgenciaDTO();
		CidadeDTO cidadeDto = new CidadeDTO();
		cidadeDto.setNome(agencia.getCidade().getNome());
		cidadeDto.setId(agencia.getCidade().getId());
		cidadeDto.setEstadoDTO(EstadoAdapter.transformaEntidadeParaDTO(agencia.getCidade().getUf()));
		dto.setId(agencia.getId());
		dto.setNumeroBanco(agencia.getNumeroBanco());
		dto.setCidadeDTO(cidadeDto);
		dto.setNumero(agencia.getNumero());
		
		return dto;
	}
}
