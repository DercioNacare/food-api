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
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Cidade;
import com.dn.code.food.domain.repository.CidadeRepository;
import com.dn.code.food.domain.service.CidadeService;

@RestController @RequestMapping("/cidades")
public class CidadeController 
{
	@Autowired private CidadeRepository cidadeRepository;
	
	@Autowired private CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar()
	{
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cidade> buscar(@PathVariable("codigo") Long codigo)
	{
		Optional<Cidade> cidade = cidadeRepository.findById(codigo);
		
		return cidade.isPresent() ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade)
	{
		Cidade cidadeSalva = cidadeService.Salvar(cidade);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable("codigo") Long codigo, @RequestBody Cidade cidade)
	{
		try
		{
			Optional<Cidade> cidadeSalva = cidadeRepository.findById(codigo);
			
			if(cidadeSalva.isPresent())
			{
				BeanUtils.copyProperties(cidade, cidadeSalva.get(), "codigo");
				cidadeService.Salvar(cidadeSalva.get());
				return ResponseEntity.ok(cidadeSalva.get());
			}
			return ResponseEntity.notFound().build();
		}
		catch(EntidadeNaoEncontradaException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Cidade> remover(@PathVariable("codigo") Long codigo)
	{
		try
		{
			cidadeService.remover(codigo);
			return ResponseEntity.noContent().build();
		}
		catch(EntidadeNaoEncontradaException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
}