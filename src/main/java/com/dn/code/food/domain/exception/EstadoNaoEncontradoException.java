package com.dn.code.food.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException{

	public EstadoNaoEncontradoException(String mensagem) 
	{
		super(mensagem);
	}
	
	public EstadoNaoEncontradoException(Long codigo)
	{
		this(String.format("Estado de código %d não encontrado", codigo));
	}
	private static final long serialVersionUID = 1L;

}
