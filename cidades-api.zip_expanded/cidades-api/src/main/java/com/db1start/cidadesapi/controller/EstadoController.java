package com.db1start.cidadesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidadesapi.adapter.EstadoAdapter;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.EstadoDTO;
import com.db1start.cidadesapi.dto.EstadoFormDTO;
import com.db1start.cidadesapi.services.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping ("/estados")
	public List<EstadoDTO> buscarTodosEstados() { 
		List<Estado> estados = estadoService.buscarTodosEstados(); 
		List<EstadoDTO> listaDeRetorno = new ArrayList<>();
		
		estados.forEach(estado -> {
			EstadoDTO meuEstadoDto = EstadoAdapter.transformaEntidadeParaDTO(estado);
			listaDeRetorno.add(meuEstadoDto);
		});
		
		return listaDeRetorno;
	}
	
	@PostMapping("/estados")
	public void cadastrarNovoEstado(@RequestBody EstadoFormDTO form) {
		estadoService.criar(form.getNome());
	}

}