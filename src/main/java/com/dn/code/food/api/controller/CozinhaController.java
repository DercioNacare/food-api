package com.dn.code.food.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.dn.code.food.domian.exception.EntidadeEmUsoException;
import com.dn.code.food.domian.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domian.service.CozinhaService;


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
	public ResponseEntity<Cozinha> buscar(@PathVariable("codigo") Long codigo)
	{
		Optional<Cozinha> cozinha = cozinhaRepository.findById(codigo);
		
		return cozinha.isPresent() ? ResponseEntity.ok(cozinha.get()) : ResponseEntity.notFound().build(); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha)
	{
		return cozinhaService.salvar(cozinha);
	}
	
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable("codigo") Long codigo, @RequestBody Cozinha cozinha)
	{
		Optional<Cozinha> cozinhaActual = cozinhaRepository.findById(codigo);
	
		if(cozinhaActual.isPresent())
		{
			BeanUtils.copyProperties(cozinha, cozinhaActual.get(), "codigo");
			return ResponseEntity.ok(cozinhaRepository.save(cozinhaActual.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Cozinha> remover(@PathVariable("codigo") Long codigo)
	{
		try
		{
			cozinhaService.remover(codigo);
			return ResponseEntity.noContent().build();
		}catch(EntidadeEmUsoException e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		catch(EntidadeNaoEncontradaException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
}