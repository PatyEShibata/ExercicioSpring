package com.db1start.cidadesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidadesapi.adapter.ClienteAdapter;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.dto.ClienteDTO;
import com.db1start.cidadesapi.dto.ClienteFormDTO;
import com.db1start.cidadesapi.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping ("/clientes")
	public List<ClienteDTO> buscarTodosClientes(){
		List<Cliente> clientes = clienteService.buscarTodosClientes();
		List<ClienteDTO> listaDeRetorno = new ArrayList<>();
		
		clientes.forEach(cliente -> {
			ClienteDTO meuClienteDto = ClienteAdapter.transformaEntidadeParaDTO(cliente);
				listaDeRetorno.add(meuClienteDto);
		});
		return listaDeRetorno;
	}
	
	@PostMapping("/clientes")
	public void cadastrarNovoCliente(@RequestBody ClienteFormDTO form) {
		clienteService.criar(form.getNome(), form.getCpf(), form.getTelefone());
	}
	
	@PutMapping("/clientes/{clienteId}")
	public void atualizaCliente(@RequestBody Long clienteId, ClienteFormDTO form) {
		clienteService.atualizar(clienteId, form);
	}
	
	@DeleteMapping("/clientes/{clienteId}")
	public void deletaCliente(@RequestBody Long clienteId) {
		clienteService.deletarPorId(clienteId);
	}
}
