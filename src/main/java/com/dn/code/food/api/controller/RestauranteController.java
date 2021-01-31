package com.dn.code.food.api.controller;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dn.code.food.domain.model.Restaurante;
import com.dn.code.food.domain.repository.RestauranteRepository;
import com.dn.code.food.domain.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController 
{
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;
	
	
	@GetMapping("/teste")
	public List<Restaurante> teste(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal)
	{
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping
	public List<Restaurante> listar()
	{
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Restaurante buscar(@PathVariable("codigo") Long codigo)
	{
		return restauranteService.buscarOuFalhar(codigo);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante salvar(@RequestBody Restaurante restaurante)
	{
		return restauranteService.salvar(restaurante);
	}
	
	@PutMapping("/{codigo}")
	public Restaurante atualizar(@PathVariable("codigo") Long codigo, @RequestBody Restaurante restaurante)
	{
		Restaurante restauranteSalvo = restauranteService.buscarOuFalhar(codigo);
		
		BeanUtils.copyProperties(restaurante, restauranteSalvo, "codigo", "formasPagamento", "endereco", "dataCadastro", "produtos") ;
		return  restauranteService.salvar(restauranteSalvo);
	}
	
	@PatchMapping("/{codigo}")
	public Restaurante atualizarParcial(@PathVariable("codigo") Long codigo, @RequestBody Map<String, Object> campos)
	{
		Restaurante restaurante = restauranteService.buscarOuFalhar(codigo);
		merge(campos, restaurante);
		
		return atualizar(codigo, restaurante);
	}

	private void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(camposOrigem, Restaurante.class);
		
		camposOrigem.forEach((nomePropriedade, valorPropriedade) ->{
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
		
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}
}