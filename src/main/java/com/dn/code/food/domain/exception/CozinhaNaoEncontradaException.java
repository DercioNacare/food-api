package com.dn.code.food.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException{

	public CozinhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	public CozinhaNaoEncontradaException(Long codigo) {
		this(String.format("Cozinha de codigo  %d não encontrada", codigo));
	}

	private static final long serialVersionUID = 1L;

}
