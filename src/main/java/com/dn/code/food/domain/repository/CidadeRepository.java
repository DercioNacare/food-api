package com.dn.code.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dn.code.food.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{

}