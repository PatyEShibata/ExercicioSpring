package com.db1start.cidadesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1start.cidadesapi.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	Optional <Cliente> findByNome(String nome);

}
