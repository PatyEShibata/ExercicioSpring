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

import com.db1start.cidadesapi.adapter.ContaAdapter;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.dto.ContaDTO;
import com.db1start.cidadesapi.dto.ContaFormDTO;
import com.db1start.cidadesapi.services.ContaService;


@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@GetMapping("/contas")
	public List<ContaDTO> buscarTodasContas(){
		List<Conta> contas = contaService.buscarTodasContas();
		List<ContaDTO> listaDeRetorno = new ArrayList<>();
		
		contas.forEach(conta-> {
			ContaDTO minhaContaDto = ContaAdapter.transformaEntidadeParaDTO(conta);
			listaDeRetorno.add(minhaContaDto);
		});
		return listaDeRetorno;
	}
	
	@PostMapping("/contas")
	public void cadastrarNovaConta(@RequestBody ContaFormDTO form) {
		contaService.criar(form.getNumero(), form.getSaldo(), form.getAgencia(), form.getCliente());
	}
	
	@PutMapping("/contas/{contaId}")
	public void atualizaConta(@PathVariable Long contaId, @RequestBody ContaFormDTO form) {
		contaService.atualizar(contaId, form);
	}
	
	@DeleteMapping("/contas/{contaId}")
	public void deletaConta(@PathVariable Long contaId) {
		contaService.deletarPorId(contaId);
	}
}
