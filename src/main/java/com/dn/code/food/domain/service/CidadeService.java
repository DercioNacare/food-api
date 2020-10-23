package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Cidade;
import com.dn.code.food.domain.model.Estado;
import com.dn.code.food.domain.repository.CidadeRepository;
import com.dn.code.food.domain.repository.EstadoRepository;

@Service
public class CidadeService  
{
	@Autowired private CidadeRepository cidadeRepository;
	
	@Autowired private EstadoRepository estadoRepository;
	
	public Cidade Salvar(Cidade cidade)
	{
		Long codigoEstado = cidade.getEstado().getCodigo();
		
		Estado estado = estadoRepository.findById(codigoEstado).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Estado de código %d não encontrado", codigoEstado)));
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void remover(Long codigo)
	{
		try
		{
			cidadeRepository.deleteById(codigo);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new EntidadeNaoEncontradaException(String.format("Cidade de código %d não ecnontrada", codigo));
		}
	}
	
}	