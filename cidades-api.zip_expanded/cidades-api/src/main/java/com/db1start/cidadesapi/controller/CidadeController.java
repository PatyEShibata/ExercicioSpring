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

import com.db1start.cidadesapi.adapter.CidadeAdapter;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.CidadeDTO;
import com.db1start.cidadesapi.dto.CidadeFormDTO;
import com.db1start.cidadesapi.services.CidadeService;

@RestController
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cidades")
	public List<CidadeDTO> buscarTodasCidades(){
		List<Cidade> cidades = cidadeService.buscarTodasCidades();
		List<CidadeDTO> listaDeRetorno = new ArrayList<>();
		
		cidades.forEach(cidade ->{
			CidadeDTO minhaCidadeDto = CidadeAdapter.transformaEntidadeParaDTO(cidade);
			listaDeRetorno.add(minhaCidadeDto);
		});
		return listaDeRetorno;
	}
	
	@PostMapping("/cidades")
	public void cadastrarNovaCidade(@RequestBody CidadeFormDTO form) {
		cidadeService.criar(form);
	}
	
	@PutMapping("/cidades/{cidadeId}")
	public void atualizaCidade(@PathVariable Long cidadeId,@RequestBody CidadeFormDTO form) {
		cidadeService.atualizar(cidadeId, form);
	}
	
	@DeleteMapping("/cidades/{cidadeId}")
	public void deletaCidade(@PathVariable Long cidadeId) {
		cidadeService.deletarPorId(cidadeId);
	}

}
