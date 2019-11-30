package com.db1start.cidadesapi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteServiceTest1 {

	@Autowired
	public ClienteService clienteService;

	@AfterEach
	public void clean() {
		clienteService.limpar();
	}

	@BeforeEach
	public void antes() {
		Cliente cliente1 = clienteService.criar("Maria", "11111111111", "1111111111");
		Cliente cliente2 = clienteService.criar("João", "22222222222", "2222222222");
		Cliente cliente3 = clienteService.criar("José", "33333333333", "3333333333");
	}
	
	@Test
	public void test() {
		Cliente cliente = clienteService.criar("Joana","44444444444", "4444444444");

		assertNotNull(cliente);
		System.out.println(cliente.getNome());
	}
	
	@Test
	public void deveDeletar() {
		List<Cliente> antesDeDeletar = clienteService.buscarTodosClientes();
		assertEquals(3, antesDeDeletar.size());
		
		clienteService.deletar("Maria");
		List<Cliente> depoisDeDeletar = clienteService.buscarTodosClientes();
		assertEquals(2, depoisDeDeletar.size());

	}
	
	@Test
	public void deveLancarExcecao() {
		try {
			Cliente cliente = clienteService.buscarPorNome("Maria");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

	}


}

