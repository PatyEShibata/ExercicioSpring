package com.db1start.cidadesapi.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
class CidadeServiceTest {

	@Autowired
	public Cidade cidade;

	@Test
	public void test() {
//		Cidade cidade = cidadeService.criar("Maringá");
//
//		assertNotNull(cidade);
//		System.out.println(cidade.getNome());
	}

}
