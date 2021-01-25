package com.dn.code.food.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido 
{
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false)
	private BigDecimal subtotal;
	
	@Column(nullable = false)
	private BigDecimal taxaFrete;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	
	private LocalDateTime dataConfirmacao;
	private LocalDateTime dataCancelamento;
	private LocalDateTime dataEntrega;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@Embedded
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario cliente;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private FormaPagamento formaPagamento;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido = new ArrayList<>();
}