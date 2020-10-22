package com.dn.code.food.domian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.repository.CozinhaRepository;
import com.dn.code.food.domian.exception.EntidadeEmUsoException;
import com.dn.code.food.domian.exception.EntidadeNaoEncontradaException;

@Service
public class CozinhaService 
{
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha)
	{
		return cozinhaRepository.save(cozinha);
	}
	
	public void remover(Long codigo)
	{
		try
		{
			cozinhaRepository.deleteById(codigo);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha de código %d", codigo));
		}
		catch(DataIntegrityViolationException e)
		{
			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", codigo));
		}
	}
}