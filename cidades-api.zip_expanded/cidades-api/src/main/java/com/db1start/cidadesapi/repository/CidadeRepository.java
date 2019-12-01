package com.db1start.cidadesapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db1start.cidadesapi.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Optional<Cidade> findByNome(String nome);
	List<Cidade> findByUfNome(String nomeEstado);
}
