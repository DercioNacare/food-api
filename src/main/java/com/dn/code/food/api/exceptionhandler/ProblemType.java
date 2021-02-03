package com.dn.code.food.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType 
{
	MENSAGEM_INCOMPREENSIVEL("mensagem-incompreensivel", "Mensagem incompreensível"),
	RECURSO_NAO_ENCONTRADO("recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("entidade-em-uso", "Entidade em uso"),
	ERRO_DE_NEGOCIO("erro-de-negocio", "Violação de regra de negocio"),
	PARAMETRO_INVALIDO("paramentro-invalido", "Parametro da URL inválido");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) 
	{
		this.uri = "http://dncode.co.mz/" + path;
		this.title = title;
	}
}
