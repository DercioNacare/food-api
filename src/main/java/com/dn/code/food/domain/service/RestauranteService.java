package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.domain.repository.CozinhaRepository;
import com.dn.code.food.domain.repository.RestauranteRepository;

@Service
public class RestauranteService 
{
	
	@Autowired private RestauranteRepository restauranteRepository;
	
	@Autowired private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante)
	{
		Long codigoCozinha = restaurante.getCozinha().getCodigo();
		
		Cozinha cozinha = cozinhaRepository.findById(codigoCozinha).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Cozinha de código %d não encontrada", codigoCozinha)));
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}
}