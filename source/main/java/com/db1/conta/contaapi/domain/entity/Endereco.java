package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Enumerated;

import org.springframework.util.Assert;


@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "logradouro", length = 60, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 30, nullable = false)
	private TipoEndereco tipoEndereco;
	
	@Column(name = "complemento", length = 100)
	private String complemento;
	
	
	protected Endereco() {}

	public Endereco(Cliente cliente, Cidade cidade, String logradouro, String numero, String cep, String complemento, TipoEndereco tipo) {
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		Assert.hasText(logradouro, "Logradouro é obrigatório");
		Assert.hasText(numero, "Número é obrigatório");
		Assert.hasText(cep, "CEP é obrigatório");
		Assert.isTrue(cep.length() == 8, "CEP Inválido");
		Assert.notNull(tipo, "Tipo de endereçõ  é obrigatório");
		this.cliente = cliente;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.tipoEndereco = tipo;
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public TipoEndereco getTipo() {
		return tipoEndereco;
	}


}





















