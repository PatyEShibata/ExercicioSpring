package com.db1start.cidadesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidadesapi.adapter.AgenciaAdapter;
import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.AgenciaFormDTO;
import com.db1start.cidadesapi.services.AgenciaService;

@RestController
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping ("/agencias")
	public List<AgenciaDTO> buscarTodasAgencias() { 
		List<Agencia> agencias = agenciaService.buscarTodasAgencias(); 
		List<AgenciaDTO> listaDeRetorno = new ArrayList<>();
		
		agencias.forEach(agencia -> {
			AgenciaDTO minhaAgenciaDto = AgenciaAdapter.transformaEntidadeParaDTO(agencia);
			listaDeRetorno.add(minhaAgenciaDto);
		});
		
		return listaDeRetorno;
	}
	
	@PostMapping("/agencias")
	public void cadastrarNovaAgencia(@RequestBody AgenciaFormDTO form) {
		agenciaService.criar(form);
	}
	
	@PutMapping("/agencias/{agenciaId}")
	public void atualizaAgencia(@PathVariable Long agenciaId, @RequestBody AgenciaFormDTO form) {
		agenciaService.atualizar(agenciaId, form);
	}
	
	@DeleteMapping("/agencias/{agenciaId}")
	public void deletaAgencia (@PathVariable Long agenciaId) {
		agenciaService.deletarPorId(agenciaId);
	}


}
