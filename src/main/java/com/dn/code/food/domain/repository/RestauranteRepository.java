package com.dn.code.food.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.infrastructure.repository.RestauranteRepositoryQueries;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries
{
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	List<Restaurante> findByNomeContainingAndCozinhaCodigo(String nome, Long codigo);
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	List<Restaurante> findTop2ByNomeContaining(String nome);
	boolean existsByNome(String nome);
}
