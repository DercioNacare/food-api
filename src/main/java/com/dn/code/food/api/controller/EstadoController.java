package com.dn.code.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.model.Estado;
import com.dn.code.food.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController 
{
	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> listar()
	{
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Estado buscar(@PathVariable("codigo")Long codigo)
	{
		return estadoRepository.findById(codigo).get();
	}
}