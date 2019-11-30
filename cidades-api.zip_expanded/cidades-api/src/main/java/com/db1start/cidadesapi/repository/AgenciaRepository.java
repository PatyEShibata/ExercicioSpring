package com.db1start.cidadesapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1start.cidadesapi.domain.entity.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>  {
	
	Optional <Agencia> findByNumero (String numero);
	List <Agencia> findByCidadeNome (String nomeCidade);

}
