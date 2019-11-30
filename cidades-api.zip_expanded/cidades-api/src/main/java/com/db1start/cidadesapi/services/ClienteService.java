package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente criar(String nome, String cpf, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, telefone);
		return clienteRepository.save(cliente);
	}

	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("cliente não encontrado"));
	}

	public void deletar(String nome) {
		Cliente cliente = buscarPorNome(nome);
		clienteRepository.delete(cliente);
	}

	public void limpar() {
		clienteRepository.deleteAll();
	}
	
	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

}
