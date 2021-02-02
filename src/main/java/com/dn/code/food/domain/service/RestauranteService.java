package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.RestauranteNaoEncontradoException;
import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.domain.repository.RestauranteRepository;

@Service
public class RestauranteService 
{
	
	@Autowired private RestauranteRepository restauranteRepository;
	
	@Autowired private CozinhaService cozinhaService;
	
	public Restaurante salvar(Restaurante restaurante)
	{
		Long codigoCozinha = restaurante.getCozinha().getCodigo();
		
		Cozinha cozinha = cozinhaService.buscarOuFalhar(codigoCozinha);
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}

	public Restaurante buscarOuFalhar(Long codigo) {
		return restauranteRepository.findById(codigo).orElseThrow(() -> new RestauranteNaoEncontradoException(codigo));
	}
}