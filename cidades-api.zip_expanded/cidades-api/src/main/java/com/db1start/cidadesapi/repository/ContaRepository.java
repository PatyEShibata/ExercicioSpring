package com.db1start.cidadesapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1start.cidadesapi.domain.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>  {
	
	Optional <Conta> findByNumero(String numeroConta);
	List <Conta> findByAgenciaNumero(String numero);

}
