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

import com.dn.code.food.domain.exception.EstadoNaoEncontradoException;
import com.dn.code.food.domain.exception.NegocioException;
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
	public Cidade buscar(@PathVariable("codigo") Long codigo)
	{
		return cidadeService.buscarOuFalhar(codigo);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade salvar(@RequestBody Cidade cidade)
	{
		try
		{
			return cidadeService.salvar(cidade);
		}
		catch(EstadoNaoEncontradoException e)
		{
			throw new NegocioException(e.getMessage());
		}
	}
	
	@PutMapping("/{codigo}")
	public Cidade atualizar(@PathVariable("codigo") Long codigo, @RequestBody Cidade cidade)
	{
		Cidade cidadeSalva = cidadeService.buscarOuFalhar(codigo);
		
		BeanUtils.copyProperties(cidade, cidadeSalva, "codigo");
		
		return salvar(cidadeSalva);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("codigo") Long codigo)
	{
		cidadeService.remover(codigo);
	}
}