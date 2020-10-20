package com.dn.code.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.repository.CozinhaRepository;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController 
{

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar()
	{
		return cozinhaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Cozinha buscar(@PathVariable("codigo") Long codigo)
	{
		return cozinhaRepository.findById(codigo).get();
	}
}