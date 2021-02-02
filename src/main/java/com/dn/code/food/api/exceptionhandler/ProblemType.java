package com.dn.code.food.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType 
{
	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) 
	{
		this.uri = "http://dncode.co.mz/" + path;
		this.title = title;
	}
}
