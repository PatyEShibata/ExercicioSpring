package com.db1start.cidadesapi.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
class AgenciaServiceTest {

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private ContaService contaService;

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;
	

	@AfterEach
	public void clean() {
		agenciaService.limpar();
		estadoService.limpar();
		clienteService.limpar();
		contaService.limpar();
		cidadeService.limpar();
		
	}

	@BeforeEach
	public void antes() {

		Cliente cliente1 = clienteService.criar("Maria", "11111111111", "1111111111");
		Cliente cliente2 = clienteService.criar("João", "22222222222", "2222222222");
		Cliente cliente3 = clienteService.criar("José", "33333333333", "3333333333");
		
		Estado parana = estadoService.criar("Paraná");
		Cidade maringa = cidadeService.criar("Maringa", parana);
		Agencia agencia1 = agenciaService.criar("1", "1234", maringa);
		Agencia agencia2 = agenciaService.criar("2","5678", maringa);
		
		contaService.criar("12345",0.0, agencia1, cliente1);
		contaService.criar("45678",0.0, agencia1, cliente2);
		contaService.criar("78912",0.0, agencia2, cliente3);
		
	}

	@Test
	public void test() {		
		
		Agencia agencia = agenciaService.buscarPorNumero("1");

		assertNotNull(agencia);
		System.out.println(agencia.getId());
	}

	@Test
	public void deveDeletarAgencia() {

		List<Agencia> antesDeDeletar = agenciaService.buscarTodasAgencias();
		Assert.assertEquals(2, antesDeDeletar.size());

		agenciaService.deletar("2");
		List<Agencia> depoisDeDeletar = agenciaService.buscarTodasAgencias();
		Assert.assertEquals(1, depoisDeDeletar.size());
	}
	
	@Test
	public void deveBuscarTodasAgenciasDeUmaCidade() {
		List <Agencia> agencias = agenciaService.buscarTodasAgenciasDeUmaCidade("Maringa");
		Assert.assertEquals(2, agencias.size());

	}

	@Test
	public void deveLancarExcecao() {
		try {
			Agencia agencia = agenciaService.buscarPorNumero("1");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
