package com.dn.code.food.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<Estado> buscar(@PathVariable("codigo")Long codigo)
	{
		Optional<Estado> estado = estadoRepository.findById(codigo);
		
		return  estado.isPresent() ? ResponseEntity.ok(estado.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado)
	{
		return estadoRepository.save(estado);
	}
}
