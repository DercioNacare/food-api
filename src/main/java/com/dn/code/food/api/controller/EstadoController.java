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

import com.dn.code.food.domain.model.Estado;
import com.dn.code.food.domain.repository.EstadoRepository;
import com.dn.code.food.domain.service.EstadoService;

@RestController @RequestMapping("/estados")
public class EstadoController 
{
	@Autowired private EstadoRepository estadoRepository;

	@Autowired private EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar()
	{
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Estado buscar(@PathVariable("codigo")Long codigo)
	{
		return estadoService.buscarOuFalhar(codigo);		
	}
	
	@PostMapping @ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado)
	{
		return estadoService.salvar(estado);
	}
	
	@PutMapping("/{codigo}")
	public Estado atualizar(@PathVariable("codigo") Long codigo, @RequestBody Estado estado)
	{
		Estado estadoSalvo = estadoService.buscarOuFalhar(codigo);
		
		BeanUtils.copyProperties(estado, estadoSalvo, "codigo");
		return estadoService.salvar(estadoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("codigo") Long codigo)
	{
		estadoService.remover(codigo);
	}
}