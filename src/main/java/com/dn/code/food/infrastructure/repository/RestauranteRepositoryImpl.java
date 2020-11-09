package com.dn.code.food.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.dn.code.food.domain.model.Restaurante;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal)
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		
		
		criteria.from(Restaurante.class);
		
		TypedQuery<Restaurante> query = entityManager.createQuery(criteria);
				
		return query.getResultList();
	}
}