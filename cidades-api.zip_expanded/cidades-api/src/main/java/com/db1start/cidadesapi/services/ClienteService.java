package com.db1start.cidadesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.dto.ClienteFormDTO;
import com.db1start.cidadesapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente criar(ClienteFormDTO dto) {
		return criar(dto.getNome(), dto.getCpf(), dto.getTelefone());
	}

	public Cliente criar(String nome, String cpf, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, telefone);
		return clienteRepository.save(cliente);
	}

	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("cliente não encontrado"));
	}
	
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("cliente não encontrado"));
	}

	public void deletar(String nome) {
		Cliente cliente = buscarPorNome(nome);
		clienteRepository.delete(cliente);
	}

	public void deletarPorId(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public void limpar() {
		clienteRepository.deleteAll();
	}
	
	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente atualizar(Long clienteId, ClienteFormDTO alteracoes) {
		Cliente cliente = buscarPorId(clienteId);
		cliente.setNome(alteracoes.getNome());
		cliente.setCpf(alteracoes.getCpf());
		cliente.setTelefone(alteracoes.getTelefone());
		return clienteRepository.save(cliente);
	}

}
