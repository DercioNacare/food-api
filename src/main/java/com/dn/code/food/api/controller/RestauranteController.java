package com.dn.code.food.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.domain.repository.RestauranteRepository;
import com.dn.code.food.domain.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController 
{
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;
	
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante)
	{
		try
		{
			restaurante = restauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		}
		catch(EntidadeNaoEncontradaException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());		
		}
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable("codigo") Long codigo, @RequestBody Restaurante restaurante)
	{
		try
		{
			Optional<Restaurante> restauranteSalvo = restauranteRepository.findById(codigo);
			
			if(restauranteSalvo.isPresent())
			{
				BeanUtils.copyProperties(restaurante, restauranteSalvo.get(), "codigo");
				restaurante = restauranteService.salvar(restauranteSalvo.get());
				return ResponseEntity.ok(restauranteSalvo.get());
			}
			return ResponseEntity.notFound().build();
		}	
		catch(EntidadeNaoEncontradaException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}