package com.dn.code.food.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException{

	public RestauranteNaoEncontradoException(String mensagem)
	{
		super(mensagem);
	}

	public RestauranteNaoEncontradoException(Long codigo) 
	{
		this(String.format("Restaurante de codigo %d não encontrado", codigo));
	}
	private static final long serialVersionUID = 1L;
}
