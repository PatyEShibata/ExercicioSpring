package com.db1start.cidadesapi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContaServiceTest1 {

	@Autowired
	private ContaService contaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@AfterEach
	public void clean() {
		contaService.limpar();
		clienteService.limpar();
		cidadeService.limpar();
		agenciaService.limpar();
	}
	
	@BeforeEach
	public void antes() {
		
		Estado parana = estadoService.criar("Paraná");
		Cidade maringa = cidadeService.criar("Maringá", parana);
		Cliente cliente1 = clienteService.criar("Maria", "11111111111", "1111111111");
		Agencia agencia1 = agenciaService.criar("1", "1234", maringa);
		Conta conta = contaService.criar("12345",0.0, agencia1, cliente1);
		
	}

	
	@Test
	public void buscarContaPorNumero() {
		Conta conta1 = contaService.buscarPorNumero("12345");
		assertNotNull(conta1);
		System.out.println(conta1.getId());
	}
	
	@Test
	public void deletarConta() {
		List<Conta> antesDeDeletar = contaService.buscarTodasContas();
		assertEquals(1, antesDeDeletar.size());
		
		contaService.deletar("12345");
		List<Conta> depoisDeDeletar = contaService.buscarTodasContas();
		assertEquals(0, depoisDeDeletar.size());

	}
	
	@Test
	public void deveBuscarAsContasDeUmaAgencia() {
		List<Conta> contas = contaService.buscarTodasContasNaAgencia("1");
		Assert.assertEquals(1, contas.size());
	}
	
	@Test
	public void deveLancarExcecao() {
		try {
			Conta conta = contaService.buscarPorNumero("2");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
