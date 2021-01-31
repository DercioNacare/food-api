package com.dn.code.food.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.repository.CozinhaRepository;
import com.dn.code.food.domain.service.CozinhaService;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController 
{

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CozinhaService cozinhaService;
	
	@GetMapping
	public List<Cozinha> listar()
	{
		return cozinhaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Cozinha buscar(@PathVariable("codigo") Long codigo)
	{
		return cozinhaService.buscarOuFalhar(codigo);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha)
	{
		return cozinhaService.salvar(cozinha);
	}
	
	
	@PutMapping("/{codigo}")
	public Cozinha atualizar(@PathVariable("codigo") Long codigo, @RequestBody Cozinha cozinha)
	{
		Cozinha cozinhaActual = cozinhaService.buscarOuFalhar(codigo);
	
		BeanUtils.copyProperties(cozinha, cozinhaActual, "codigo");
		
		return cozinhaService.salvar(cozinhaActual);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("codigo") Long codigo)
	{
		cozinhaService.remover(codigo);
	}
}