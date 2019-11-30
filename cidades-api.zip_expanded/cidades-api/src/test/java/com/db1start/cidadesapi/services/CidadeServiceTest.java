package com.db1start.cidadesapi.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
class CidadeServiceTest {

	@Autowired
	public CidadeService cidadeService;
	
	@Autowired
	public AgenciaService agenciaService;
	
	@Autowired
	public EstadoService estadoService;
	
	@AfterEach
	public void clean() {
		cidadeService.limpar();
		agenciaService.limpar();
		estadoService.limpar();
	}
	
	@BeforeEach
	public void antes() {
		Estado parana = estadoService.criar("Parainá");
		
		Cidade maringa = cidadeService.criar("Maringá", parana);
		Cidade curitiba = cidadeService.criar("Curitiba", parana);
		
		agenciaService.criar("1", "1234", maringa);
		agenciaService.criar("2","5678", maringa);
		agenciaService.criar("3","91234", curitiba);
	}


	@Test
	public void test() {
		Estado sp = estadoService.criar("São Paulo");
		Cidade cidade = cidadeService.criar("São Paulo", sp);

		assertNotNull(cidade);
		System.out.println(cidade.getNome());
	}
	
	@Test
	public void deveBuscarCidade() {
		Cidade cidade = cidadeService.buscarPorNome("Maringá");
		assertNotNull(cidade);
	}
	
	@Test
	public void deveDeletarCidade() {
		List<Cidade> antesDeDeletar = cidadeService.buscarTodasCidades();
		assertEquals(2, antesDeDeletar.size());
		
		cidadeService.deletar("Maringá");
		List<Cidade> depoisDeDeletar = cidadeService.buscarTodasCidades();
		assertEquals(1, depoisDeDeletar.size());
	}
	
	@Test
	public void deveBuscarTodasCidadesDeUmEstado() {
		List<Cidade>cidades = cidadeService.buscarTodasCidadesDeUmEstado("Paraná");
		assertEquals(2, cidades.size());
	}
	
	@Test
	public void deveLancarExcecao() {
		try {
			Cidade cidade = cidadeService.buscarPorNome("São Paulo");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

	}


}
