package com.dn.code.food.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException{

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	public CidadeNaoEncontradaException(Long codigo) 
	{
		this(String.format("Cidade de codigo %d não encontrada", codigo));
	}
	private static final long serialVersionUID = 1L;

}
