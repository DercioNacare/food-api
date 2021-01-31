package com.dn.code.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.exception.EntidadeEmUsoException;
import com.dn.code.food.domain.exception.EntidadeNaoEncontradaException;
import com.dn.code.food.domain.model.Cidade;
import com.dn.code.food.domain.model.Estado;
import com.dn.code.food.domain.repository.CidadeRepository;

@Service
public class CidadeService  
{
	private static final String MSG_CIDADE_NAO_ENCONTRADA = "Cidade de código %d não ecnontrada";

	@Autowired private CidadeRepository cidadeRepository;
	
	@Autowired private EstadoService estadoService;
	
	public Cidade salvar(Cidade cidade)
	{
		Long codigoEstado = cidade.getEstado().getCodigo();
		
		Estado estado = estadoService.buscarOuFalhar(codigoEstado);
		
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
			throw new EntidadeNaoEncontradaException(String.format(MSG_CIDADE_NAO_ENCONTRADA, codigo));
		}
		catch(DataIntegrityViolationException e)
		{
			throw new EntidadeEmUsoException(String.format("Cidade de código %d não pode ser removida, por estar em uso em outra entidade", codigo));
		}
	}

	public Cidade buscarOuFalhar(Long codigo) 
	{
		return cidadeRepository.findById(codigo).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_CIDADE_NAO_ENCONTRADA, codigo)));
	}
	
}	