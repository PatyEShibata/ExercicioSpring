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

import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
class EstadoServiceTest1 {

	@Autowired
	private EstadoService estadoService;

	@AfterEach
	public void clean() {
		estadoService.limpar();
	}

	@BeforeEach
	public void antes() {
		Estado parana = estadoService.criar("Paraná");
		Estado santaCatarina = estadoService.criar("Santa Catarina");
		Estado rioGrandeDoSul = estadoService.criar("Rio Grande do Sul");
	}

	@Test
	public void deveBuscarEstado() {
		Estado estado = estadoService.buscarPorNome("Paraná");
		assertNotNull(estado);
	}

	@Test
	public void deveDeletarEstado() {
		List<Estado> antesDeDeletar = estadoService.buscarTodosEstados();
		assertEquals(3, antesDeDeletar.size());

		estadoService.deletar("Paraná");
		List<Estado> depoisDeDeletar = estadoService.buscarTodosEstados();
		assertEquals(2, depoisDeDeletar.size());
	}

	@Test
	public void deveLancarExcecao() {
		try {
			Estado estado = estadoService.buscarPorNome("São Paulo");
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
