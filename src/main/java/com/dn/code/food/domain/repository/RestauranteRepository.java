package com.dn.code.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dn.code.food.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>
{

}
