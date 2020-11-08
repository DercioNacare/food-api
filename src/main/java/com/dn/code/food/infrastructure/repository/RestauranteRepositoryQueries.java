package com.dn.code.food.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import com.dn.code.food.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}