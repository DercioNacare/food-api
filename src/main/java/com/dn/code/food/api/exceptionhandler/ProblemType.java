package com.dn.code.food.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType 
{
	MENSAGEM_INCOMPREENSIVEL("mensagem-incompreensivel", "Mensagem incompreensível"),
	ENTIDADE_NAO_ENCONTRADA("entidade-nao-encontrada", "Entidade não encontrada"),
	ENTIDADE_EM_USO("entidade-em-uso", "Entidade em uso"),
	ERRO_DE_NEGOCIO("erro-de-negocio", "Violação de regra de negocio");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) 
	{
		this.uri = "http://dncode.co.mz/" + path;
		this.title = title;
	}
}
