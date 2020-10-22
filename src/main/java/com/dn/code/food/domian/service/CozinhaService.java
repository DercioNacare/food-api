package com.dn.code.food.domian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.code.food.domain.model.Cozinha;
import com.dn.code.food.domain.repository.CozinhaRepository;

@Service
public class CozinhaService 
{
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha)
	{
		return cozinhaRepository.save(cozinha);
	}
}