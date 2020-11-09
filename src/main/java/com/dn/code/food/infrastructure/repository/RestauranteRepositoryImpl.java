package com.dn.code.food.infrastructure.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dn.code.food.domain.model.Restaurante;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal)
	{
		
		var parametros = new HashMap<String, Object>();
		
		var jpql = new StringBuilder();
		jpql.append("from Restaurante where 0 = 0 ");
		
		if(StringUtils.hasLength(nome))
		{
			jpql.append("and nome like :nome ");
			
			parametros.put("nome", "%" + nome + "%"); 
		}
		
		if(taxaFreteInicial != null)
		{
			jpql.append("and taxaFrete >= :taxaFreteInicial ");
			
			parametros.put("taxaFreteInicial", taxaFreteInicial);
		}
		
		if(taxaFreteFinal != null)
		{
			jpql.append("and taxaFrete <= :taxaFreteFinal");
			
			parametros.put("taxaFreteFinal", taxaFreteFinal);
		}
		
		TypedQuery<Restaurante> query = entityManager.createQuery(jpql.toString(), Restaurante.class);
				
		parametros.forEach((chave, valor) ->{
			query.setParameter(chave, valor);
		});
		
		return query.getResultList();
	}
}