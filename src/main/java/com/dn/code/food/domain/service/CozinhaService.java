package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.EntidadeEmUsoException;
import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.repository.CozinhaRepository;

@Service
public class CozinhaService 
{
	private static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser removida, pois está em uso";
	private static final String MSG_COZINHA_NA0_ENCONTRADA = "Não existe cadastro de cozinha de código %d";
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
			throw new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NA0_ENCONTRADA, codigo));
		}
		catch(DataIntegrityViolationException e)
		{
			throw new EntidadeEmUsoException(String.format(MSG_COZINHA_EM_USO, codigo));
		}
	}
	public Cozinha buscarOuFalhar(Long codigo)
	{
		return cozinhaRepository.findById(codigo).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NA0_ENCONTRADA,codigo)));
		
	}
}