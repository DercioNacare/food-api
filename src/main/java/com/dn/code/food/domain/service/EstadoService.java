package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.EntidadeEmUsoException;
import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Estado;
import com.dn.code.food.domain.repository.EstadoRepository;

@Service
public class EstadoService 
{
	private static final String MSG_ESTADO_NAO_ENCONTRADO = "Estado de código %d não encontrado";
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado)
	{
		return estadoRepository.save(estado);
	}
	
	public void remover(Long codigo)
	{
		try
		{
			estadoRepository.deleteById(codigo);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new EntidadeNaoEncontradaException(String.format(MSG_ESTADO_NAO_ENCONTRADO, codigo));
		}
		catch(DataIntegrityViolationException e)
		{
			throw new EntidadeEmUsoException(String.format("Estado de código %d não pode ser removida, pois está em uso", codigo));
		}
	}

	public Estado buscarOuFalhar(Long codigo) 
	{
		return estadoRepository.findById(codigo).orElseThrow(()-> new EntidadeNaoEncontradaException(String.format(MSG_ESTADO_NAO_ENCONTRADO,codigo)));
	}
}