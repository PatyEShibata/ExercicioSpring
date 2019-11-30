package com.db1start.cidadesapi.services;

import static org.junit.jupiter.api.Assertions.*;

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
class DepositoServiceTest {

	@Autowired
	private DepositoService depositoService;
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private ClienteService clienteService;
	
	private Conta conta;
	
	@AfterEach
	public void clean() {
		contaService.limpar();
		agenciaService.limpar();
		cidadeService.limpar();
		estadoService.limpar();
		clienteService.limpar();
	}

	
	@BeforeEach
	public void antes() {
		Estado parana = estadoService.criar("Paraná");
		Cidade maringa = cidadeService.criar("Maringa", parana);
		Agencia agencia1 = agenciaService.criar("1", "1234", maringa);
		Cliente cliente = clienteService.criar("Maria", "11111111111", "1111111111");
		conta = contaService.criar ("12345",200.0, agencia1, cliente);
	}
	
	@Test
	public void deveRetornar300() {
        Double expected = 300.00;
        Conta response = depositoService.depositar("12345", 100.00);
        Assert.assertEquals(expected, response.getSaldo());
	}

}
