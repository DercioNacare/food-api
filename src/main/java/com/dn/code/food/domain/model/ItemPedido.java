package com.dn.code.food.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido 
{
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Integer quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	private String observacao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
}
