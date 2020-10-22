package com.dn.code.food.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController 
{
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping
	public List<Restaurante> listar()
	{
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Restaurante> buscar(@PathVariable("codigo") Long codigo)
	{
		Optional<Restaurante> restaurante = restauranteRepository.findById(codigo);
		
		if(restaurante.isPresent())
		{
			return ResponseEntity.ok(restaurante.get());
		}
		return ResponseEntity.notFound().build();
	}
}